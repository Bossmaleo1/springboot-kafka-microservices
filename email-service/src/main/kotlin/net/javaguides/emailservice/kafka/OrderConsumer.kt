package net.javaguides.emailservice.kafka

import net.javaguides.basedomains.dto.OrderEvent
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.kafka.annotation.KafkaListener
import org.springframework.stereotype.Service

@Service
class OrderConsumer {

    companion object {
        val LOGGER: Logger = LoggerFactory.getLogger(OrderConsumer::class.java)
    }

    @KafkaListener(topics = ["order_topics"], groupId = "stock")
    fun consume(event: OrderEvent) {
        LOGGER.info(String.format("Order event received in email service -> %s", event.toString()))

        //send on email to the customer
    }
}