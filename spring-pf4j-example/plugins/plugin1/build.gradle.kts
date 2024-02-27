plugins {
    kotlin("jvm")
    kotlin("kapt")
}

dependencies {
    compileOnly(project(":api"))
    compileOnly("org.pf4j:pf4j:3.8.0")

    kapt("org.pf4j:pf4j:3.8.0")
}

