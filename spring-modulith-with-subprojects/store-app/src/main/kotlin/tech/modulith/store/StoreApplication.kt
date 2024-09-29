package tech.modulith.store

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.modulith.core.ApplicationModules
import org.springframework.modulith.docs.Documenter
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@SpringBootApplication
class StoreApplication

fun main(args: Array<String>) {
    runApplication<StoreApplication>(*args)
}

@RestController
@RequestMapping("/sys")
class StoreApplicationController {
    private val modules: ApplicationModules = ApplicationModules.of(StoreApplication::class.java)

    @GetMapping("/gen-doc")
    fun genDoc() {
        Documenter(modules).writeDocumentation()
    }

}