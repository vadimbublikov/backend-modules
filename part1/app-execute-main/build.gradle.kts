plugins {
    java
}

tasks.withType<Jar> {
    manifest {
        attributes["Main-Class"] = "fully.qualified.MainClass"
    }
}