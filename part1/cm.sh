#plain
java -cp app.jar fully.qualified.MainClass
java -jar app.jar
java --module-path app.jar --module app



#spring
java -jar app.jar
java -cp app.jar org.springframework.boot.loader.JarLauncher
java -cp app.jar org.springframework.boot.loader.PropertiesLauncher
java --module-path app.jar --module app
