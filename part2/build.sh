#build and publish modules
cd catalog && ./gradlew build publishToMavenLocal && cd ..
cd cart && ./gradlew build publishToMavenLocal && cd ..
cd order && ./gradlew build publishToMavenLocal && cd ..
cd payment && ./gradlew build publishToMavenLocal && cd ..
cd notification && ./gradlew build publishToMavenLocal && cd ..

#build app and copy modules
cd store-app && ./gradlew build && cd ..
rm -rf ./store-app/build/libs/modules
mkdir -p ./store-app/build/libs/modules
cp ./catalog/catalog-impl/build/libs/catalog-impl-0.0.1.jar ./store-app/build/libs/modules
cp ./cart/cart-impl/build/libs/cart-impl-0.0.1.jar ./store-app/build/libs/modules
cp ./order/order-impl/build/libs/order-impl-0.0.1.jar ./store-app/build/libs/modules
cp ./payment/payment-impl/build/libs/payment-impl-0.0.1.jar ./store-app/build/libs/modules
cp ./notification/notification-impl/build/libs/notification-impl-0.0.1.jar ./store-app/build/libs/modules