package chapter3

import java.time.LocalDateTime

class DeliveryService {
    fun isDeliveryValid(delivery: Delivery): Boolean {
        val deliveryTime = delivery.date
        val maxValidTime = LocalDateTime.now().plusMinutes(2*24*60-1)
        return deliveryTime.isEqual(maxValidTime) || deliveryTime.isAfter(maxValidTime)

    }
}