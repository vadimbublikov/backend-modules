package tech.modulith.store

import org.junit.jupiter.api.Test
import org.springframework.modulith.core.ApplicationModules
import org.springframework.modulith.docs.Documenter

class ModulithSnippetsTest {
    private val modules: ApplicationModules = ApplicationModules.of(StoreApplication::class.java)

    @Test
    fun listModules() {
        modules.forEach(::println)
    }

    @Test
    fun verifyModules() {
        modules.verify()
    }

    @Test
    fun createDoc() {
        Documenter(modules).writeDocumentation()
    }

}