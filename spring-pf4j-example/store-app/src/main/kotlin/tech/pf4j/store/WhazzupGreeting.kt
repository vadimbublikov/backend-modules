package tech.pf4j.store

import org.pf4j.Extension
import org.springframework.stereotype.Component
import tech.pf4j.api.Greeting

@Extension
@Component
class WhazzupGreeting: Greeting {

    override fun getGreeting(): String {
        return "Whazzup"
    }

}