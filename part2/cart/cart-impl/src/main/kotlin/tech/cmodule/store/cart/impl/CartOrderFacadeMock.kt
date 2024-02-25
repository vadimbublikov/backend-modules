package tech.cmodule.store.cart.impl

import tech.cmodule.store.order.api.IOrderFacade
import tech.cmodule.store.order.api.OrderRq
import tech.cmodule.store.order.api.OrderRs

class CartOrderFacadeMock : IOrderFacade {
    override fun order(rq: OrderRq): OrderRs {
        return OrderRs(orderId = "id_order_mock")
    }
}