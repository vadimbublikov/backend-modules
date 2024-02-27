package tech.pf4j.plugin1

import tech.pf4j.api.Greeting

class WelcomeGreeting: Greeting {

    override fun getGreeting(): String {
        return "Welcome"
    }

}