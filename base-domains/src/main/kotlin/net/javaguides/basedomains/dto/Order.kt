package net.javaguides.basedomains.dto

import lombok.AllArgsConstructor
import lombok.Data
import lombok.NoArgsConstructor


@Data
@NoArgsConstructor
@AllArgsConstructor
data class Order(
    var orderId: String,
    val name: String,
    val qty: Int,
    val price: Double
)
