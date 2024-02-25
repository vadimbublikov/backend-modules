package tech.cmodule.store.catalog.impl

import tech.cmodule.store.cart.api.*

class CartFacadeMock : ICartFacade {
    override fun cartToOrder(rq: CartToOrderRq): CartToOrderRs {
        return CartToOrderRs(orderId = "order_id_mock")
    }

    override fun createItem(rq: CreateItemRq): CreateItemRs {
        return CreateItemRs(cartItemId = "cart_item_id_mock")
    }
}