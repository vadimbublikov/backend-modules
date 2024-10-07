### spring-cmodule-example  
Пример приложения с использованием classpath modules  

Для запуска любого из модулей с помощью gradle таски launch в первый раз необходимо предварительно собрать и опубликовать основное приложение store-app, т.е. выполнить gradlew build publishToMavenLocal

* build.sh - соберёт и опубликует все модули
* start.sh - запустит основное приложение и все модули одновременно
* build_start.sh - выполнит build.sh и затем start.sh
 