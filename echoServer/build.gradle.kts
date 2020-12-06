import org.jetbrains.kotlin.gradle.plugin.mpp.KotlinNativeTargetPreset

plugins {
    kotlin("multiplatform") version "1.4.20"
}

repositories {
    mavenCentral()
}

kotlin {
    // Configure executables for all targets.
    macosX64("echoServer") {
        binaries {
            executable {
                entryPoint = "sample.echoserver.main"
                runTask?.args(3000)
            }
        }
    }

    // Enable experimental stdlib API used by the sample.
    sourceSets.all {
        languageSettings.useExperimentalAnnotation("kotlin.ExperimentalStdlibApi")
    }
}