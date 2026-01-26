package chapter4


import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class `Example 4-6` {

    @Test
    fun test(){
        val sut = UserRepository()

        val user = sut.getById(5)

        assertEquals("dummy sql",sut.lastExecutedSqlStatement)


    }
}