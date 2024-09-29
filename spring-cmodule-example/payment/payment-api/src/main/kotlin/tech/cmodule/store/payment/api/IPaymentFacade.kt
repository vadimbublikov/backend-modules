package tech.cmodule.store.payment.api

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
 * Event, about the payment has processed
 */
data class PaymentProcessed(
    val paymentId: String,
    val currency: Currency,
    val amount: Amount
)

enum class Currency {RUB, USD, EUR}

typealias Amount = BigDecimal