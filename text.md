# Текст для презентации
## 1. Вспоминаем как запускается java приложение
```shell
java -jar app.jar
```
```shell
Hello World!
```
![alt text](./image/unpackaged_jar.png "unpackaged jar")
![alt text](./image/manifest_main.png "manifest main class")
```kotlin
tasks.withType<Jar> {
    manifest {
        attributes["Main-Class"] = "fully.qualified.MainClass"
    }
}
```
```xml
<project>
  ...
  <build>
    <plugins>
      <plugin>
        <groupId>org.apache.maven.plugins</groupId>
        <artifactId>maven-jar-plugin</artifactId>
        ...
        <configuration>
          <archive>
            <manifest>
              <addClasspath>true</addClasspath>
              <mainClass>fully.qualified.MainClass</mainClass>
            </manifest>
          </archive>
        </configuration>
        ...
      </plugin>
    </plugins>
  </build>
  ...
</project>
```
## 2. Изучаем как запускается spring boot приложение (JarLauncher, PropertiesLauncher)

**classpath.idx** - определяет последовательность добавления jar в classpath  
**layers.idx** - позволяет разделить jar на логические слои для создания докер образа  
**org.springframework.boot.loader.jar.JarFile** - основной класс для загрузки файлов из стандартного местоположения и из 
вложенных jar файлов. При первой загрузке местоположение каждого JarEntry c физическим смещением в основном jar
Вооружившись этой информацией, мы можем загрузить определенные вложенные записи, обратившись к соответствующей части 
основного jar. Нам не нужно распаковывать архив, и нам не нужно считывать все входные данные в память.


