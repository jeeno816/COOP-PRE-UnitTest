package chapter3

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class `Example 3-6` {
    val _sut = Calculator()


    @Test
    fun sum_of_two_numbers() {
        val first = 10.0
        val second = 20.0

        val result = _sut.sum(first,second)

        assertEquals(30.0,result)

    }
}