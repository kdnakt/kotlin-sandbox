plugins {
    kotlin("multiplatform") version "1.4.21"
}

group = "me.akito"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

kotlin {
    macosX64("native") {
        binaries {
            executable {
                entryPoint = "main"
            }
        }
    }
    sourceSets {
        commonMain {
            dependencies {
                implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.4.2")
            }
        }
    }
}
