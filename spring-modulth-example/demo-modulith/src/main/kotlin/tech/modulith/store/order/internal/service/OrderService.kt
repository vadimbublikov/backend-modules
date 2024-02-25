package tech.modulith.store.order.internal.service

import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import tech.modulith.store.order.IOrderFacade
import tech.modulith.store.order.OrderRq
import tech.modulith.store.order.OrderRs
import tech.modulith.store.payment.IPaymentFacade
import tech.modulith.store.payment.PaymentProcessRq
import java.math.BigDecimal

@Service
@Transactional
class OrderService(private val paymentFacade: IPaymentFacade) : IOrderFacade {

    override fun order(rq: OrderRq): OrderRs {
        val orderId = "order-" + rq.productSet.joinToString("-") { it }
        paymentFacade.processPayment(PaymentProcessRq(BigDecimal.valueOf(rq.productSet.size*101L)))
        return OrderRs(orderId = orderId)
    }

}