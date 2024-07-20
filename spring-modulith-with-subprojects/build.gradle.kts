group = "tech.modulith.store"
version = "0.0.1-SNAPSHOT"

subprojects {
    repositories {
        mavenLocal()
        mavenCentral()
    }
}

plugins {

    kotlin("jvm") apply false
    id("org.springframework.boot") apply false
    kotlin("plugin.spring") apply false
    kotlin("plugin.serialization") apply false
    id("io.spring.dependency-management") version "1.0.10.RELEASE" apply false

}
