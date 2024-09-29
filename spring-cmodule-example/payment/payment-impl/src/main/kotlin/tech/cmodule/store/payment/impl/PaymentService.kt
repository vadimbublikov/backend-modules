package tech.cmodule.store.payment.impl

import jakarta.annotation.PostConstruct
import org.slf4j.LoggerFactory
import org.springframework.context.ApplicationEventPublisher
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import tech.cmodule.store.payment.api.Currency
import tech.cmodule.store.payment.api.IPaymentFacade
import tech.cmodule.store.payment.api.PaymentProcessRq
import tech.cmodule.store.payment.api.PaymentProcessRs
import tech.cmodule.store.payment.api.PaymentProcessed
import java.util.*

@Service
class PaymentService(
    private val events: ApplicationEventPublisher
) : IPaymentFacade {

    @Transactional
    override fun processPayment(rq: PaymentProcessRq): PaymentProcessRs {
        val paymentId = UUID.randomUUID().toString()
        val event = PaymentProcessed(paymentId, currency = Currency.RUB ,rq.amount)
        events.publishEvent(event)
        return PaymentProcessRs(paymentId = paymentId)
    }

    private val log = LoggerFactory.getLogger(this::class.java)

    @PostConstruct
    fun init() {
        log.info("payment")
    }

}