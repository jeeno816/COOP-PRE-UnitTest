package chapter7.v8

import chapter7.UserType
import chapter7.v7.EmailChangedEvent
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class `Example 7-14` {
    @Test
    fun changing_email_from_corporate_to_non_corporate(){
        val company = Company("mycorp.com",1)
        val sut= User(1,"user@mycorp.com", UserType.Employee,false)

        sut.changeEmail("new@gmail.com",company)

        assertEquals(0,company.numberOfEmployees)
        assertEquals(sut.email,"new@gmail.com")
        assertEquals(sut.type,UserType.Customer)
        assertTrue(sut.emailChangedEvents.contains(EmailChangedEvent(1,"new@gmail.com")))
    }
}