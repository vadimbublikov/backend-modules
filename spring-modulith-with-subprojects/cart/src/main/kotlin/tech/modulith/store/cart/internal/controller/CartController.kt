package tech.modulith.store.cart.internal.controller

import kotlinx.serialization.Serializable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import tech.modulith.store.cart.internal.service.CartService

@RestController
@RequestMapping("/cart")
class CartController(
    val service: CartService
): CartApi {

    @PostMapping("/list")
    override fun listCart(): ListCartRs {
        val cs = service.cartSet.map { ListCartRsData(itemId = it.first, productId = it.second) }
        return ListCartRs(cs)
    }

    @PostMapping("/order")
    override fun orderCart(): OrderCartRs {
        val orderId = service.cartToOrder()
        return OrderCartRs(orderId)
    }

}

interface CartApi {
    fun listCart(): ListCartRs
    fun orderCart(): OrderCartRs
}

@Serializable
data class ListCartRs(
    val data: List<ListCartRsData>
)

@Serializable
data class ListCartRsData(
    val itemId: String,
    val productId: String
)

@Serializable
data class OrderCartRs(
    val orderId: String
)