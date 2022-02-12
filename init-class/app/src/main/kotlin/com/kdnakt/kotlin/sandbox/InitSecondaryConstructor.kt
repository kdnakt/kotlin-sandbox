package com.kdnakt.kotlin.sandbox

class InitSecondaryConstructor(name: String) {
    val firstProperty = "First property: $name".also(::println)

    init {
        println("First initializer block that prints $name")
    }

    constructor(name: String, age: Int) : this(name) {
        println("Secondary constructor: age=$age")
    }

    val secondProperty = "Second property: ${name.length}".also(::println)

    init {
        println("Second initializer block that prints ${name.length}")
    }
}