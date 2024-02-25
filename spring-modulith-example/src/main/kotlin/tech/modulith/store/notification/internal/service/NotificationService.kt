package tech.modulith.store.notification.internal.service

import org.springframework.modulith.events.ApplicationModuleListener
import org.springframework.stereotype.Component
import org.springframework.stereotype.Service
import tech.modulith.store.notification.INotificationFacade
import tech.modulith.store.payment.PaymentProcessed

@Service
class NotificationService(
    val channel: IChannel
) : INotificationFacade {

    override fun notifyAboutSomething() {
        TODO("Not yet implemented")
    }

    @ApplicationModuleListener
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