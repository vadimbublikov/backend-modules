package tech.cmodule.store.catalog.impl

import tech.cmodule.store.order.api.IOrderFacade
import tech.cmodule.store.order.api.OrderRq
import tech.cmodule.store.order.api.OrderRs

class OrderFacadeMock : IOrderFacade {
    override fun order(rq: OrderRq): OrderRs {
        return OrderRs(orderId = "id_order_mock")
    }
}