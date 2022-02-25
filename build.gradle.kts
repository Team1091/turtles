import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    kotlin("jvm") version "1.6.10"
    application
}

application {
    mainClassName = "com.team1091.turtles.MainKt"
}

group = "com.team1091"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    implementation(kotlin("stdlib-jdk8"))
    implementation("org.processing:core:3.3.7")
}

tasks.withType<KotlinCompile> {
    kotlinOptions.jvmTarget = "11"
}