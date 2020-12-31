package sample.workers

import kotlin.native.concurrent.*

data class WorkerArgument(val intParam: Long, val stringParam: String)
data class WorkerResult(val intResult: Long, val stringResult: String)

fun main() {
    val count = 10
    val workers = Array(count) { Worker.start() }

    for (attempt in 1..3) {
        val futures = Array(workers.size) { workerIndex ->
            workers[workerIndex].execute(TransferMode.SAFE, {
                WorkerArgument(workerIndex.toLong(), "attempt $attempt of $workerIndex")
            }) { input ->
                var sum = 0L
                for (i in 0..input.intParam * 1000) {
                    sum += i
                }
                val res = WorkerResult(sum, input.stringParam + " result")
                println(res)
                res
            }
        }
        val futureSet = futures.toSet()
        var consumed = 0
        while (consumed < futureSet.size) {
            val ready = waitForMultipleFutures(futureSet, 100000)
            ready.forEach {
                it.consume { result ->
                    //println("${result.stringResult} ${result.intResult}")
                    if (!result.stringResult.startsWith("attempt $attempt")) throw Error("Unexpected $result")
                    consumed++
                }
            }
        }
    }
    workers.forEach {
        it.requestTermination().result
    }
    println("Workers: OK")
}