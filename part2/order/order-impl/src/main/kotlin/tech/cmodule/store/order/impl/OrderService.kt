package tech.cmodule.store.order.impl

import jakarta.annotation.PostConstruct
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import tech.cmodule.store.order.api.IOrderFacade
import tech.cmodule.store.order.api.OrderRq
import tech.cmodule.store.order.api.OrderRs
import tech.cmodule.store.payment.api.IPaymentFacade
import tech.cmodule.store.payment.api.PaymentProcessRq
import java.math.BigDecimal

@Service
@Transactional
class OrderService(
    private val paymentFacade: IPaymentFacade = PaymentFacadeMock()
) : IOrderFacade {
    private val log = LoggerFactory.getLogger(this::class.java)

    @PostConstruct
    fun init() {
        log.info("order")
    }

    override fun order(rq: OrderRq): OrderRs {
        val orderId = "order-" + rq.productSet.joinToString("-") { it }
        paymentFacade.processPayment(PaymentProcessRq(BigDecimal.valueOf(rq.productSet.size * 101L)))
        return OrderRs(orderId = orderId)
    }

}