package chapter3


import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import java.time.LocalDateTime

class `Example 3-10`  {
    @Test
    fun isDeliveryValid_InvalidDate_ReturnsFalse(){
        val sut = DeliveryService()
        val pastDate = LocalDateTime.now().minusDays(1)
        val delivery = Delivery(pastDate)
        val result = sut.isDeliveryValid(delivery)
        assertFalse(result)
    }

}