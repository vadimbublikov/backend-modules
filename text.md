# Текст для презентации

```shell
java -jar app.jar
```

```kotlin
tasks.withType<Jar> {
    manifest {
        attributes["Main-Class"] = "tech.bvd.app.AppKt"
    }
}
```

```shell
Hello World!
```

![alt text](./image/unpackaged_jar.png "unpackaged jar")

![alt text](./image/manifest_main.png "manifest main class")