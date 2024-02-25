package tech.modulith.store.cart

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.mock.mockito.MockBean
import org.springframework.modulith.test.ApplicationModuleTest
import tech.modulith.store.cart.CreateItemRq
import tech.modulith.store.cart.ICartFacade
import tech.modulith.store.order.IOrderFacade

@ApplicationModuleTest
class CartIntegrationTest {

    @Autowired
    lateinit var cartFacade: ICartFacade

    @MockBean
    lateinit var orderFacadeMock: IOrderFacade

    @Test
    fun `place product to cart test`() {
        val rq = CreateItemRq(productId = "grill")

        val res = cartFacade.createItem(rq)

        assertThat(res.error).isNull()
        assertThat(res.cartItemId)
            .isNotNull()
            .contains("grill")
    }

}