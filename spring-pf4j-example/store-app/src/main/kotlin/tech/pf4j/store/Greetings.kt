package tech.pf4j.store

import jakarta.annotation.PostConstruct
import org.springframework.stereotype.Component
import tech.pf4j.api.Greeting

@Component
class Greetings(val greetings: List<Greeting>) {

    @PostConstruct
    fun printGreetings() {
        println(
            String.format(
                "Found %d extensions for extension point '%s'",
                greetings.size,
                Greeting::class.java.name
            )
        )
        for (greeting in greetings) {
            println(">>> " + greeting.getGreeting())
        }
    }

}