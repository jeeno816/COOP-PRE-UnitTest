package chapter3


import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.MethodSource
import java.time.LocalDateTime

class `Example 3-12`  {
    @ParameterizedTest
    @MethodSource("provideArguments")
    fun detects_an_invalid_delivery_date(daysFromNow:Int){
        val sut = DeliveryService()
        val pastDate = LocalDateTime.now().plusDays(daysFromNow.toLong())
        val delivery = Delivery(pastDate)
        val result = sut.isDeliveryValid(delivery)
        assertFalse(result)
    }

    companion object {
        @JvmStatic
        fun provideArguments()=listOf(-1,0,1)
    }

    @Test
    fun the_soonest_delivery_date_is_two_days_from_now(){
        val sut = DeliveryService()
        val pastDate = LocalDateTime.now().plusDays(2)
        val delivery = Delivery(pastDate)
        val result = sut.isDeliveryValid(delivery)
        assertTrue(result)
    }


}