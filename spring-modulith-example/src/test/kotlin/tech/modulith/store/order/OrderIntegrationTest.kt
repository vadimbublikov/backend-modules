package tech.modulith.store.order

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.mock.mockito.MockBean
import org.springframework.modulith.test.ApplicationModuleTest
import tech.modulith.store.payment.IPaymentFacade

@ApplicationModuleTest
class OrderIntegrationTest {

    @Autowired
    lateinit var orderFacade: IOrderFacade

    @MockBean
    lateinit var paymentFacadeMock: IPaymentFacade

    @Test
    fun `order product set`() {
        val productSet = setOf("grill", "gas", "spatula")
        val rq = OrderRq(productSet)

        val res = orderFacade.order(rq)

        assertThat(res.error).isNull()

    }

}