package tech.modulith.store.notification

import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.modulith.test.ApplicationModuleTest
import org.springframework.modulith.test.Scenario
import tech.modulith.store.notification.internal.service.IChannel
import tech.modulith.store.payment.PaymentProcessed
import java.math.BigDecimal

@ApplicationModuleTest
class NotificationIntegrationTest {

    @Autowired
    lateinit var channel: IChannel

    @Test
    fun `notification from event test`(scenario: Scenario) {
        val paymentEvent = PaymentProcessed(paymentId = "123", amount = BigDecimal.valueOf(99.99))

        scenario.publish(paymentEvent).andWaitForStateChange(
            {channel.send("Payment id=${paymentEvent.paymentId} amount=${paymentEvent.amount} has been completed")}
        )

    }

}