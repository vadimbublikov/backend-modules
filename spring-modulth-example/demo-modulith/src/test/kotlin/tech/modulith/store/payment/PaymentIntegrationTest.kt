package tech.modulith.store.payment

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.modulith.test.ApplicationModuleTest
import org.springframework.modulith.test.AssertablePublishedEvents
import java.math.BigDecimal

@ApplicationModuleTest
class PaymentIntegrationTest {

    @Autowired
    lateinit var paymentFacade: IPaymentFacade

    @Test
    fun `payment process test`() {
        val amount = BigDecimal.valueOf(100.12)
        val rq = PaymentProcessRq(amount = amount)

        val rs = paymentFacade.processPayment(rq)

        assertThat(rs.error).isNull()
        assertThat(rs.paymentId).isNotNull()
    }

    @Test
    fun `payment process complete must publish event`(events: AssertablePublishedEvents) {
        val amount = BigDecimal.valueOf(100.12)
        val rq = PaymentProcessRq(amount = amount)

        val rs = paymentFacade.processPayment(rq)

        assertThat(events)
            .contains(PaymentProcessed::class.java)
            .matching(PaymentProcessed::paymentId, rs.paymentId)
            .matching(PaymentProcessed::amount, amount)
    }




}