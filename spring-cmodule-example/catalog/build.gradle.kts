val kotlinSerializationJson: String by project

group = "tech.cmodule.store"
version = "0.0.1"

subprojects {
    repositories {
        mavenLocal()
        mavenCentral()
    }
}

plugins {
    kotlin("jvm") apply false
    kotlin("plugin.serialization") apply false
    id("io.spring.dependency-management") apply false
    id("org.springframework.boot") apply false
}


repositories {
    mavenLocal()
    mavenCentral()
}