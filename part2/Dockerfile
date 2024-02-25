FROM bellsoft/liberica-openjdk-alpine:21

EXPOSE 8080
VOLUME /tmp
COPY ./store-app/build/libs/store-app-*.jar /opt/backend/store-app.jar
COPY ./catalog/catalog-impl/build/libs/catalog-impl-*.jar /opt/backend/modules/
COPY ./cart/cart-impl/build/libs/cart-impl-*.jar /opt/backend/modules/
COPY ./order/order-impl/build/libs/order-impl-*.jar /opt/backend/modules/
COPY ./payment/payment-impl/build/libs/payment-impl-*.jar /opt/backend/modules/
COPY ./notification/notification-impl/build/libs/notification-impl-*.jar /opt/backend/modules/
ENTRYPOINT ["java", "-cp", "/opt/backend/store-app.jar", "-Dloader.path=/opt/backend/modules/", "org.springframework.boot.loader.launch.PropertiesLauncher"]
