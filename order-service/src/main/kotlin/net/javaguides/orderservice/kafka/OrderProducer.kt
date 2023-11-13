package net.javaguides.orderservice.kafka

import net.javaguides.basedomains.dto.OrderEvent
import org.apache.kafka.clients.admin.NewTopic
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.kafka.core.KafkaTemplate
import org.springframework.kafka.support.KafkaHeaders
import org.springframework.messaging.support.MessageBuilder
import org.springframework.stereotype.Service

@Service
class OrderProducer(
    val topic: NewTopic,
    val kafkaTemplate: KafkaTemplate<String, OrderEvent>
) {

    companion object {
        val LOGGER: Logger = LoggerFactory.getLogger(OrderProducer::class.java)
    }

    fun sendMessage(event: OrderEvent) {
        LOGGER.info(String.format("Message sent %s", event.toString()))

        // create Message
        val message = MessageBuilder
            .withPayload(event)
            .setHeader(KafkaHeaders.TOPIC, topic.name())
            .build()

        kafkaTemplate.send(message)
    }
}