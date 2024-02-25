package tech.modulith.store.cart

/**
 * Facade for cart module functions
 */
interface ICartFacade {

    fun createItem(rq: CreateItemRq): CreateItemRs

    fun cartToOrder(rq: CartToOrderRq): CartToOrderRs


}

data class CreateItemRq(
    val productId: String
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