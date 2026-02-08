package chapter7.v4

import chapter7.UserType
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource

class Tests {
    @Test
    fun changing_email_from_non_corporate_to_corporate(){
        val company = Company("mycorp.com",1)
        val sut = User(1,"user@gmail.com",UserType.Customer)

        sut.changeEmail("new@mycorp.com",company)

        assertEquals(2,company.numberOfEmployees)
        assertEquals("new@mycorp.com",sut.email)
        assertEquals(UserType.Employee,sut.type)
    }
    @Test
    fun changing_email_from_corporate_to_non_corporate(){
        val company = Company("mycorp.com",2)
        val sut = User(1,"new@mycorp.com",UserType.Employee)

        sut.changeEmail("user@gmail.com",company)

        assertEquals(1,company.numberOfEmployees)
        assertEquals("user@gmail.com",sut.email)
        assertEquals(UserType.Customer,sut.type)
    }
    @Test
    fun changing_email_without_changing_user_type(){
        val company = Company("mycorp.com",1)
        val sut = User(1,"user1@gmail.com",UserType.Customer)

        sut.changeEmail("user2@gmail.com",company)

        assertEquals(1,company.numberOfEmployees)
        assertEquals("user2@gmail.com",sut.email)
        assertEquals(UserType.Customer,sut.type)
    }
    @Test
    fun changing_email_to_the_same_one(){
        val company = Company("mycorp.com",1)
        val sut = User(1,"user@gmail.com",UserType.Customer)

        sut.changeEmail("user@gmail.com",company)

        assertEquals(1,company.numberOfEmployees)
        assertEquals("user@gmail.com",sut.email)
        assertEquals(UserType.Customer,sut.type)
    }

    @ParameterizedTest
    @CsvSource(
        "mycorp.com, email@mycorp.com, true",
        "mycorp.com, email@gmail.com, false",
    )
    fun differentiates_a_corporate_email_from_non_corporate(domain:String,email:String,expectedResult:Boolean){
        val sut = Company(domain,0)

        val isEmailCorporate = sut.isEmailCorporate(email)

        assertEquals(expectedResult,isEmailCorporate)
    }



}