package chapter5

import io.mockk.mockk
import io.mockk.verify
import org.junit.jupiter.api.Test

class `Example 5-1` {

    @Test
    fun sending_a_greetings_email(){
        val mock = mockk<IEmailGateway>(relaxed = true)
        val sut = Controller(mock)

        sut.greetUser("user@email.com")

        verify(exactly = 1){sut.greetUser("user@email.com")}

    }
}