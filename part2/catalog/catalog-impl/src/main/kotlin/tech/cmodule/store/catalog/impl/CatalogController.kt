package tech.cmodule.store.catalog.impl

import kotlinx.serialization.Serializable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/catalog")
class CatalogController(
    val service: CatalogService
) : CatalogApi {

    @PostMapping("/list")
    override fun listProduct(@RequestBody rq: ListProductRq): ListProductRs {
        val data = service.listProduct()
        return ListProductRs(data)
    }

    @PostMapping("/product-to-cart")
    override fun productToCart(@RequestBody rq: ProductToCartRq): ProductToCartRs {
        val cartItemId = service.productToCart(rq.productId)
        return ProductToCartRs(cartItemId)
    }

    @PostMapping("product-to-order")
    override fun productToOrder(@RequestBody rq: ProductToOrderRq): ProductToOrderRs {
        val orderId = service.productToOrder(productId = rq.productId)
        return ProductToOrderRs(orderId)
    }

}

interface CatalogApi {
    fun listProduct(rq: ListProductRq): ListProductRs
    fun productToCart(rq: ProductToCartRq): ProductToCartRs
    fun productToOrder(rq: ProductToOrderRq): ProductToOrderRs
}

@Serializable
data class ListProductRq(
    val limit: Int = 100
)

@Serializable
data class ListProductRs(
    val data: List<String>
)

@Serializable
data class ProductToCartRq(
    val productId: String
)

@Serializable
data class ProductToCartRs(
    val cartItemId: String
)

@Serializable
data class ProductToOrderRq(
    val productId: String
)

@Serializable
data class ProductToOrderRs(
    val orderId: String
)