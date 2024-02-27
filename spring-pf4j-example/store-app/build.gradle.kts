import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

val kotlinSerializationJson: String by project

plugins {
	kotlin("jvm")
	kotlin("plugin.serialization")
	kotlin("plugin.spring")
	id("io.spring.dependency-management")
	id("org.springframework.boot")
	id("maven-publish")
}

group = "tech.pf4j.store"
version = "0.0.1"

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
	implementation("org.jetbrains.kotlin:kotlin-reflect")
	implementation("org.jetbrains.kotlinx:kotlinx-serialization-json:$kotlinSerializationJson")
	implementation("org.liquibase:liquibase-core")

	implementation("org.pf4j:pf4j-spring:0.8.0") {
		exclude("org.slf4j")
	}
	implementation("org.pf4j:pf4j:3.8.0")

	implementation(project(":api"))

	runtimeOnly("com.h2database:h2")
	runtimeOnly("org.springframework.boot:spring-boot-starter-actuator")

	testImplementation("org.springframework.boot:spring-boot-starter-test")
}

tasks.withType<KotlinCompile> {
	kotlinOptions {
		freeCompilerArgs += "-Xjsr305=strict"
		jvmTarget = "17"
	}
}

tasks.withType<Test> {
	useJUnitPlatform()
}

tasks.named<Jar>("jar") {
	archiveClassifier.set("")
	enabled = false
}

tasks.withType<GenerateModuleMetadata> {
	enabled = false
}

publishing {
	publications {
		create<MavenPublication>("maven") {
			from(components["kotlin"])
			artifact(tasks["bootJar"])
			pom {
				packaging = "jar"
			}
		}

	}
}