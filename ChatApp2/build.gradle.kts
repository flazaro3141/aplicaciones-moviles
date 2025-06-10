// build.gradle.kts (raíz)
plugins {
    id("com.google.gms.google-services") version "4.4.2" apply false
}

// Declarar la propiedad extra primero
extra["kotlin_version"] = "1.8.0"

buildscript {
    val kotlin_version: String by extra
    repositories {
        google()
        mavenCentral()
    }
    dependencies {
        classpath("com.android.tools.build:gradle:7.3.1")
        classpath("org.jetbrains.kotlin:kotlin-gradle-plugin:$kotlin_version")
        classpath("com.google.gms:google-services:4.3.15")
    }
}
