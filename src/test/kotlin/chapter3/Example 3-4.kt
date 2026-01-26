package chapter3


import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class `Example 3-4` {
    @Test
    fun sum_of_two_numbers() {
        //준비
        val first = 10.0
        val second = 20.0
        val sut = Calculator()

        //실행
        val result = sut.sum(first,second)

        //검증
        assertEquals(30.0,result)

    }
}