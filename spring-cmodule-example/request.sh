curl 'http://localhost:8080/catalog/list' \
  -H 'Content-Type: application/json' \
  --data-raw '{}'


curl 'http://localhost:8080/catalog/product-to-cart' \
  -H 'Content-Type: application/json' \
  --data-raw '{ "productId": "grill" }'


curl 'http://localhost:8080/catalog/product-to-order' \
  -H 'Content-Type: application/json' \
  --data-raw '{ "productId": "gas" }'

curl 'http://localhost:8080/cart/list' \
  -H 'Content-Type: application/json' \
  --data-raw '{ }'

curl 'http://localhost:8080/cart/order' \
  -H 'Content-Type: application/json' \
  --data-raw '{ }'



