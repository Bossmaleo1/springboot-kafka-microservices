package net.javaguides.basedomains.dto

import lombok.AllArgsConstructor
import lombok.Data
import lombok.NoArgsConstructor

@Data
@AllArgsConstructor
@NoArgsConstructor
data class OrderEvent (
    val message: String,
    val status: String,
    val order: Order
)