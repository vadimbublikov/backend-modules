package tech.cmodule.store.order.api

/**
 * Facade for order module functions
 */
interface IOrderFacade {

    fun order(rq: OrderRq): OrderRs

}

data class OrderRq(
    val productSet: Set<String>
)

data class OrderRs(
    val error: Exception? = null,
    val orderId: String
)
