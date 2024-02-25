package tech.cmodule.store.order.impl

import tech.cmodule.store.payment.api.IPaymentFacade
import tech.cmodule.store.payment.api.PaymentProcessRq
import tech.cmodule.store.payment.api.PaymentProcessRs

class PaymentFacadeMock : IPaymentFacade {
    override fun processPayment(rq: PaymentProcessRq): PaymentProcessRs {
        return PaymentProcessRs(paymentId = "id_payment_mock")
    }
}