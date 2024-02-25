#plain-app
java -cp app.jar fully.qualified.MainClass
java -jar app.jar
java --module-path app.jar --module app



#spring-app
java -jar app.jar
java -cp app.jar org.springframework.boot.loader.JarLauncher
java -cp app.jar org.springframework.boot.loader.PropertiesLauncher
java --module-path app.jar --module app

#slide1
java -cp plain-app.jar fully.qualified.MainClass
java -jar plain-app.jar
java --module-path plain-app.jar --module plain.app

#slide2
java -jar spring-app.jar
java -cp spring-app.jar o.sf.b.l.JarLauncher
java -cp spring-app.jar o.sf.b.l.PropertiesLauncher
java --module-path spring-app.jar --module spring.app