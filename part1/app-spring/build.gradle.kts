import org.springframework.boot.gradle.tasks.bundling.BootJar

plugins {
	id("org.springframework.boot") version "3.1.5"
	id("io.spring.dependency-management") version "1.1.3"
	java
}

repositories {
	mavenCentral()
}

tasks.withType<Jar> {
	enabled = false
}

tasks.withType<BootJar> {
	manifest {
		attributes["Start-Class"] = "fully.qualified.MainClass"
	}
	enabled = true
	archiveFileName.set("spring-app.jar")
}

dependencies {
	implementation("org.springframework.boot:spring-boot-starter")
}