package tech.modulith.store

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import tech.modulith.store.payment.internal.service.PaymentService

@SpringBootTest
class StoreApplicationTest {

    @Autowired
    lateinit var paymentService: PaymentService

    @Test
    fun contextLoads() {
        assertThat(this::paymentService.isInitialized).isTrue()
    }

}