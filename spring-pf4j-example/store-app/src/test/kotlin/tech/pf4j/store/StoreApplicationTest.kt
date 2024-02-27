package tech.pf4j.store

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.springframework.boot.test.context.SpringBootTest

@SpringBootTest
class StoreApplicationTest {

    @Test
    fun contextLoads() {
        assertThat(true).isTrue()
    }

}