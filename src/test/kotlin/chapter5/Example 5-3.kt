package chapter5

import io.mockk.*
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class `Example 5-3` {

    @Test
    fun creating_a_report(){
        val stub = mockk<IDatabase>()
        every{ stub.getNumberOfUsers()} returns 10
        val sut = Controller(stub)

        val report = sut.createReport()

        assertEquals(10,report?.numberOfUsers)
        verify(exactly = 1){stub.getNumberOfUsers()}

    }
}