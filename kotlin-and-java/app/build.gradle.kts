/*
 * This file was generated by the Gradle 'init' task.
 */

plugins {
    id("com.kdnakt.kotlin.and.java.kotlin-application-conventions")
}

dependencies {
    implementation("org.apache.commons:commons-text")
    implementation(project(":utilities"))
}

application {
    // Define the main class for the application.
    mainClass.set("com.kdnakt.kotlin.and.java.app.AppKt")
}