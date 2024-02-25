package tech.modulith.store.payment.internal.service

import org.springframework.context.ApplicationEventPublisher
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import tech.modulith.store.payment.IPaymentFacade
import tech.modulith.store.payment.PaymentProcessRq
import tech.modulith.store.payment.PaymentProcessRs
import tech.modulith.store.payment.PaymentProcessed
import java.util.UUID

@Service
class PaymentService(
    private val events: ApplicationEventPublisher
): IPaymentFacade {

    @Transactional
    override fun processPayment(rq: PaymentProcessRq): PaymentProcessRs {
        val paymentId = UUID.randomUUID().toString()
        val event = PaymentProcessed(paymentId = paymentId, amount = rq.amount)
        events.publishEvent(event)
        return PaymentProcessRs(paymentId = paymentId)
    }

}