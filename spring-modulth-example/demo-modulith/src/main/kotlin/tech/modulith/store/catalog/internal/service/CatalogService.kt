package tech.modulith.store.catalog.internal.service

import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import tech.modulith.store.cart.CreateItemRq
import tech.modulith.store.cart.ICartFacade
import tech.modulith.store.catalog.ICatalogFacade
import tech.modulith.store.order.IOrderFacade
import tech.modulith.store.order.OrderRq

@Service
@Transactional
class CatalogService(
    private val cart: ICartFacade,
    private val order: IOrderFacade
) : ICatalogFacade {

    fun productToCart(productId: String): String {
        val res = cart.createItem(CreateItemRq(productId = productId))
        if (res.error != null) {
            throw res.error
        } else {
            return res.cartItemId!!
        }
    }

    fun productToOrder(productId: String): String {
        return order.order(OrderRq(productSet = setOf(productId))).orderId
    }

    fun listProduct(): List<String> {
        return listOf("grill", "gas", "spatula")
    }

}