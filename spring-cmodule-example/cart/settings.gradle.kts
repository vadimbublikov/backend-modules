rootProject.name = "cart"

pluginManagement {
    val kotlinVersion: String by settings
    val springBootVersion: String by settings
    val springDependencyManagement: String by settings

    plugins {
        kotlin("jvm") version kotlinVersion apply false
        kotlin("plugin.serialization") version kotlinVersion apply false
        kotlin("plugin.spring") version kotlinVersion apply false

        id("org.springframework.boot") version springBootVersion apply false
        id("io.spring.dependency-management") version springDependencyManagement apply false

    }
}

include("cart-impl")
include("cart-api")
include("cart-launcher")
