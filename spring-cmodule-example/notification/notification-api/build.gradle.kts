import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
	kotlin("jvm")
	id("maven-publish")
}

group = rootProject.group
version = rootProject.version

java {
	sourceCompatibility = JavaVersion.VERSION_17
	withJavadocJar()
	withSourcesJar()
}

tasks.withType<KotlinCompile> {
	kotlinOptions {
		freeCompilerArgs += "-Xjsr305=strict"
		jvmTarget = "17"
	}
}