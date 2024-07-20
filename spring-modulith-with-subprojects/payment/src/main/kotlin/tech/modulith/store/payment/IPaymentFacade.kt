package tech.modulith.store.payment

import java.math.BigDecimal

/**
 * Facade for payment module functions
 */
interface IPaymentFacade {

    fun processPayment(rq: PaymentProcessRq): PaymentProcessRs

}

data class PaymentProcessRq(
    val amount: BigDecimal
)

data class PaymentProcessRs(
    val paymentId: String,
    val error: Exception? = null
)

/**
 * Event about payment processed
 */
data class PaymentProcessed(
    val paymentId: String,
    val amount: BigDecimal
)
