package chapter4

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class `Example 4-5` {

    @Test
    fun test(){
        val sut = User()

        sut.name = "John Smith"

        assertEquals("John Smith",sut.name)


    }
}