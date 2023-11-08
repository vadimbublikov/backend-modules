# Текст для презентации
## 1. Вспоминаем как запускается java приложение
```shell
java -jar app.jar  
  
java может сделать вид что jar это модуль, но у модуля есть требование к его наименованию его имя должно соотвествовать 
корневому экспортируемому пакету, например  
java.desktop.jmod, java.logging.jmod, jdk.xml.dom.jmod   
Правила именования модулей аналогичны тому, как мы называем пакеты (точки разрешены, тире - нет). 
Очень часто используются имена в стиле project (my.module) или Reverse-DNS (com.baeldung.mymodule). 
В этом руководстве мы будем использовать стиль проекта.

There are four types of modules in the new module system:  
System Modules – These are the modules listed when we run the list-modules command above. They include the Java SE and JDK modules.  
Application Modules – These modules are what we usually want to build when we decide to use Modules. They are named and defined in the compiled module-info.class file included in the assembled JAR.  
Automatic Modules – We can include unofficial modules by adding existing JAR files to the module path. The name of the module will be derived from the name of the JAR. Automatic modules will have full read access to every other module loaded by the path.  
Unnamed Module – When a class or JAR is loaded onto the classpath, but not the module path, it’s automatically added to the unnamed module. It’s a catch-all module to maintain backward compatibility with previously-written Java code.  

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


