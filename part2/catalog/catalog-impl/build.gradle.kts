import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

val kotlinSerializationJson: String by project
val cartVersion: String by project
val orderVersion: String by project
val springBootVersion: String by project

plugins {
	kotlin("jvm")
	kotlin("plugin.serialization")
	kotlin("plugin.spring")
	id("io.spring.dependency-management")
	id("maven-publish")
}

group = rootProject.group
version = rootProject.version

java {
	sourceCompatibility = JavaVersion.VERSION_17
}

val includeInJar by configurations.creating

dependencies {
	compileOnly("org.springframework:spring-context")
	compileOnly("org.liquibase:liquibase-core")
	
	compileOnly("org.springframework.boot:spring-boot-starter-web")
	compileOnly("org.springframework.boot:spring-boot-starter-data-jpa")
	compileOnly("org.jetbrains.kotlin:kotlin-reflect")
	compileOnly("org.jetbrains.kotlinx:kotlinx-serialization-json:$kotlinSerializationJson")

	compileOnly("tech.cmodule.store:cart-api:$cartVersion")
	compileOnly("tech.cmodule.store:order-api:$orderVersion")

	implementation(project(":catalog-api"))

	includeInJar(project(":catalog-api"))

}

tasks.getByName<Jar>("jar") {
	duplicatesStrategy = DuplicatesStrategy.EXCLUDE
	from(
		includeInJar.filter {
			it.name.startsWith("catalog-api")
		}.map { if (it.isDirectory) it else zipTree(it) }
	)
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

publishing {
	publications {
		create<MavenPublication>("maven") {
			from(components["java"])
		}
	}
}

dependencyManagement {
	imports {
		mavenBom("org.springframework.boot:spring-boot-dependencies:$springBootVersion")
	}
}