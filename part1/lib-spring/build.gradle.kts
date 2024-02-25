plugins {
	id("io.spring.dependency-management") version "1.1.3"
	java
}

repositories {
	mavenCentral()
}

dependencies {
	compileOnly("org.springframework:spring-context")
	compileOnly("jakarta.annotation:jakarta.annotation-api")
}

tasks.withType<Jar> {
	archiveFileName.set("spring-lib.jar")
}

dependencyManagement {
	imports {
		mavenBom("org.springframework.boot:spring-boot-dependencies:3.1.5")
	}
}
