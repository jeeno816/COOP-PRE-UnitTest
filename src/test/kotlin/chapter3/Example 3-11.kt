package chapter3


import org.junit.jupiter.api.Assertions.*

import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource
import java.time.LocalDateTime
import java.util.stream.Stream

class `Example 3-11`  {
    @ParameterizedTest
    @MethodSource("provideArguments")
    fun can_detect_an_invalid_delivery_date(daysFromNow:Int , expected:Boolean){
        val sut = DeliveryService()
        val pastDate = LocalDateTime.now().plusDays(daysFromNow.toLong())
        val delivery = Delivery(pastDate)
        val result = sut.isDeliveryValid(delivery)
        assertEquals(expected,result)
    }

    companion object {
        @JvmStatic
        fun provideArguments(): Stream<Arguments> {
            return Stream.of(Arguments.of(-1,false),Arguments.of(0,false),Arguments.of(1,false),Arguments.of(2,true))
        }
    }


}