package chapter3


import org.junit.jupiter.api.Assertions.*

import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource
import java.time.LocalDateTime
import java.util.stream.Stream

class `Example 3-13`  {
    @ParameterizedTest
    @MethodSource("provideArguments")
    fun can_detect_an_invalid_delivery_date(deliveryDate: LocalDateTime, expected:Boolean){
        val sut = DeliveryService()
        val delivery = Delivery(deliveryDate)
        val result = sut.isDeliveryValid(delivery)
        assertEquals(expected,result)
    }

    companion object {
        @JvmStatic
        fun provideArguments(): Stream<Arguments> {
            return Stream.of(Arguments.of(LocalDateTime.now().plusDays(-1L),false),Arguments.of(LocalDateTime.now(),false),
                Arguments.of(LocalDateTime.now().plusDays(1L),false),Arguments.of(LocalDateTime.now().plusDays(2L),true))
        }
    }


}