package chapter1

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test


class IsStringLongTest {

    @Test
    fun test_1_1_v1(){
        val result = isStringLong("abc")
        assertFalse(result)
    }
    @Test
    fun test_1_1_v2(){
        val result = isStringLong2("abc")
        assertFalse(result)
    }
    @Test
    fun test_1_2(){
        val result = isStringLong3("abc")
        assertFalse(result)
    }

    @Test
    fun test_1_3(){
        val result1 = isStringLong("abc")
        val result2 = isStringLong("abcdef")
    }
}