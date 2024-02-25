package tech.cmodule.store.cart.impl

import jakarta.annotation.PostConstruct
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import tech.cmodule.store.cart.api.*
import tech.cmodule.store.order.api.IOrderFacade
import tech.cmodule.store.order.api.OrderRq


@Service
@Transactional
class CartService(
    private val orderFacade: IOrderFacade = CartOrderFacadeMock()
) : ICartFacade {
    private val log = LoggerFactory.getLogger(this::class.java)

    val cartSet = mutableSetOf<Pair<String, String>>()

    @PostConstruct
    fun init() {
        log.info("cart")
    }

    override fun createItem(rq: CreateItemRq): CreateItemRs {
        val cartItemId = "cart item with product = ${rq.productId}"
        println("quantity = ${rq.quantity}")
        cartSet.add(Pair(cartItemId, rq.productId))
        return CreateItemRs(cartItemId = cartItemId)
    }

    override fun cartToOrder(rq: CartToOrderRq): CartToOrderRs {
        val rs = orderFacade.order(OrderRq(productSet = cartSet.map { it.second }.toSet()))
        cartSet.clear()
        return CartToOrderRs(orderId = rs.orderId)
    }

    fun cartToOrder(): String {
        val rs = orderFacade.order(OrderRq(productSet = cartSet.map { it.second }.toSet()))
        cartSet.clear()
        return rs.orderId
    }

}