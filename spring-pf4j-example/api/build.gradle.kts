plugins {
    kotlin("jvm")
}

group = "tech.pf4j.store"
version = "0.0.1"

dependencies {
    implementation("org.pf4j:pf4j-spring:0.8.0") {
        exclude("org.slf4j")
    }
}