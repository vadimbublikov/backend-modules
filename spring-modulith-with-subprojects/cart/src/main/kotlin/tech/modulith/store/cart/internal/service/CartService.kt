package tech.modulith.store.cart.internal.service

import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import tech.modulith.store.order.IOrderFacade
import tech.modulith.store.order.OrderRq
import tech.modulith.store.cart.*

@Service
@Transactional
class CartService(private val orderFacade: IOrderFacade) : ICartFacade {

    val cartSet = mutableSetOf<Pair<String, String>>()

    override fun createItem(rq: CreateItemRq): CreateItemRs {
        val cartItemId = "cart item with product = ${rq.productId}"
        cartSet.add(Pair(cartItemId, rq.productId))
        return CreateItemRs(cartItemId = "cart item with product = ${rq.productId}")
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