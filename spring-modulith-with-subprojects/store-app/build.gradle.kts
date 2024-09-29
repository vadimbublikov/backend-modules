import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

val springModulithVersion: String by project
val kotlinSerializationJson: String by project
val braveVersion: String by project
val springBootVersion: String by project

//val includeInJar by configurations.creating

plugins {
    kotlin("jvm")
    kotlin("plugin.serialization")
    kotlin("plugin.spring")
    id("io.spring.dependency-management")
    id("org.springframework.boot")
}

group = rootProject.group
version = rootProject.version

java {
    sourceCompatibility = JavaVersion.VERSION_17
}

repositories {
    mavenLocal()
    mavenCentral()
}

dependencies {
    implementation("org.springframework.boot:spring-boot-starter-web")
    implementation("org.springframework.boot:spring-boot-starter-data-jpa")
    implementation("com.fasterxml.jackson.module:jackson-module-kotlin")
    implementation("org.jetbrains.kotlin:kotlin-reflect")
    implementation("org.springframework.modulith:spring-modulith-starter-core")
    implementation("org.springframework.modulith:spring-modulith-core")
    implementation("org.springframework.modulith:spring-modulith-events-api")
    implementation("org.jetbrains.kotlinx:kotlinx-serialization-json:$kotlinSerializationJson")
    implementation("io.zipkin.brave:brave-instrumentation-okhttp3")
    implementation("io.micrometer:micrometer-tracing-bridge-brave")

    implementation(project(":cart"))
    implementation(project(":catalog"))
    implementation(project(":notification"))
    implementation(project(":order"))
    implementation(project(":payment"))

//    includeInJar(project(":cart"))
//    includeInJar(project(":catalog"))
//    includeInJar(project(":notification"))
//    includeInJar(project(":order"))
//    includeInJar(project(":payment"))

    runtimeOnly("com.h2database:h2")
    runtimeOnly("org.springframework.boot:spring-boot-starter-actuator")
    runtimeOnly("org.springframework.modulith:spring-modulith-actuator")
    runtimeOnly("org.springframework.modulith:spring-modulith-observability-vadim:1.1.1")

    testImplementation("org.springframework.boot:spring-boot-starter-test")
    testImplementation("org.springframework.modulith:spring-modulith-starter-test")
}

dependencyManagement {
    imports {
        mavenBom("org.springframework.boot:spring-boot-dependencies:$springBootVersion")
        mavenBom("org.springframework.modulith:spring-modulith-bom:$springModulithVersion")
        mavenBom("io.zipkin.brave:brave-bom:$braveVersion")
    }
}

tasks.withType<KotlinCompile> {
    kotlinOptions {
        freeCompilerArgs += "-Xjsr305=strict"
        jvmTarget = "17"
    }
}

//tasks.getByName<Jar>("jar") {
//    duplicatesStrategy = DuplicatesStrategy.EXCLUDE
//    includeInJar.forEach { println(it.name) }
//    from(
//        includeInJar
//            .filter { it.name.startsWith("tech.") }
//            .map { if (it.isDirectory) it else zipTree(it) }
//    )
//}

tasks.withType<Test> {
    useJUnitPlatform()
}
