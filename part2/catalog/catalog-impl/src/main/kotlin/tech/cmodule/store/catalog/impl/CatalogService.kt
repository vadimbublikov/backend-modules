package tech.cmodule.store.catalog.impl

import jakarta.annotation.PostConstruct
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import tech.cmodule.store.cart.api.CreateItemRq
import tech.cmodule.store.cart.api.ICartFacade
import tech.cmodule.store.catalog.api.ICatalogFacade
import tech.cmodule.store.order.api.IOrderFacade
import tech.cmodule.store.order.api.OrderRq


@Service
@Transactional
class CatalogService(
    private val cart: ICartFacade = CartFacadeMock(),
    private val order: IOrderFacade = OrderFacadeMock()
) : ICatalogFacade {
    private val log = LoggerFactory.getLogger(this::class.java)

    @PostConstruct
    fun init() {
        log.info("catalog")
    }

    fun productToCart(productId: String): String {
        val res = cart.createItem(CreateItemRq(productId = productId))
        val resErr = res.error
        if (resErr != null) {
            throw resErr
        } else {
            return res.cartItemId!!
        }

    }

    fun productToOrder(productId: String): String {
        return order.order(OrderRq(productSet = setOf(productId))).orderId
    }

    fun listProduct(): List<String> {
        return listOf("grill", "gas", "spatula", "sauce")
    }

}