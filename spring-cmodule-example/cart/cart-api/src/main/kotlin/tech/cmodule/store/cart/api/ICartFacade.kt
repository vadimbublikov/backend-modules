package tech.cmodule.store.cart.api

/**
 * Facade for cart module functions
 */

interface ICartFacade {


    fun createItem(rq: CreateItemRq): CreateItemRs

    fun cartToOrder(rq: CartToOrderRq): CartToOrderRs

}

data class CreateItemRq @JvmOverloads constructor(
    val productId: String,
    val quantity: Int = 1
)

data class CreateItemRs(
    val error: Exception? = null,
    val cartItemId: String? = null
)

data class CartToOrderRq(
    val productId: String
)

data class CartToOrderRs(
    val error: Exception? = null,
    val orderId: String
)