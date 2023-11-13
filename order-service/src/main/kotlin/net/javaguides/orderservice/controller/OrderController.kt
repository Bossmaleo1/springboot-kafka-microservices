package net.javaguides.orderservice.controller


import net.javaguides.basedomains.dto.Order
import net.javaguides.basedomains.dto.OrderEvent
import net.javaguides.orderservice.kafka.OrderProducer
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import java.util.UUID

@RestController
@RequestMapping("/api/v1")
class OrderController(
    val orderProducer: OrderProducer
) {


    @PostMapping("/orders")
    fun placeOrder(@RequestBody order: Order): String {

        order.orderId  = UUID.randomUUID().toString()

        val orderEvent = OrderEvent(
            message = "Order status is in pending state",
            status = "PENDING",
            order = order
        )

        orderProducer.sendMessage(orderEvent)

        return "Order placed successfully ..."
    }
}