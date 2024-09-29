package tech.cmodule.store

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.stereotype.Component
import org.springframework.transaction.event.TransactionPhase
import org.springframework.transaction.event.TransactionalEventListener

@SpringBootApplication
class StoreApplication

fun main(args: Array<String>) {
    runApplication<StoreApplication>(*args)
}

@Component
class MyListener {

    @TransactionalEventListener(phase = TransactionPhase.AFTER_COMMIT)
    fun onEvent(event: MyEvent) {
        println("after commit event")
    }

}

data class MyEvent (
    val text: String
)
