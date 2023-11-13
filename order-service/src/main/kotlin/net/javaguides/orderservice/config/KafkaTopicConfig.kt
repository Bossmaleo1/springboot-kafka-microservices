package net.javaguides.orderservice.config

import org.apache.kafka.clients.admin.NewTopic
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.kafka.config.TopicBuilder


@Configuration
class KafkaTopicConfig {

    // spring bean for kafka topic
    @Bean
    fun topic() : NewTopic {
        return TopicBuilder.name("order_topics")
            .partitions(3)
            .build()
    }
}