#start with modules
java -cp ./store-app/build/libs/store-app-0.0.1.jar \
  -Dloader.path=./store-app/build/libs/modules/ \
  org.springframework.boot.loader.launch.PropertiesLauncher