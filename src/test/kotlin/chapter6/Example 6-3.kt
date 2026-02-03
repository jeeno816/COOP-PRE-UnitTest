package chapter6


import org.junit.jupiter.api.Test
import chapter5.*
import io.mockk.*


class `Example 6-3` {
    @Test
    fun sending_a_greetings_email(){
        val emailGatewayMock = mockk<IEmailGateway>(relaxed = true)
        val sut = Controller(emailGatewayMock)

        sut.greetUser("user@email.com")

        verify(exactly = 1){sut.greetUser("user@email.com")}

    }
}