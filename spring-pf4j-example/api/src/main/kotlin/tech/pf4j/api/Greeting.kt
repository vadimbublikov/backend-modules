package tech.pf4j.api

import org.pf4j.ExtensionPoint

interface Greeting: ExtensionPoint {

    fun getGreeting(): String

}