package tech.cmodule.store.notification.impl

import jakarta.annotation.PostConstruct
import org.slf4j.LoggerFactory
import org.springframework.scheduling.annotation.Async
import org.springframework.stereotype.Component
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Propagation
import org.springframework.transaction.annotation.Transactional
import org.springframework.transaction.event.TransactionalEventListener
import tech.cmodule.store.notification.api.INotificationFacade
import tech.cmodule.store.payment.api.PaymentProcessed


@Service
class NotificationService(
    val channel: IChannel
) : INotificationFacade {
    private val log = LoggerFactory.getLogger(this::class.java)

    @PostConstruct
    fun init() {
        log.info("notification")
    }

    override fun notifyAboutSomething() {
        TODO("Not yet implemented")
    }

    @Async
    @Transactional(propagation = Propagation.REQUIRES_NEW)
    @TransactionalEventListener
    fun notifyAboutPayment(event: PaymentProcessed) {
        channel.send("Notification: payment id=${event.paymentId} amount=${event.amount} has been completed")
    }
}

interface IChannel {
    fun send(message: String)
}

@Component
class StdOutChannel : IChannel {
    override fun send(message: String) {
        println(message)
    }
}