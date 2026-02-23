package chapter8.v1


import chapter8.Company
import chapter8.CompanyFactory
import chapter8.Database
import chapter8.IMessageBus
import chapter8.UserFactory
import chapter8.UserType
import io.mockk.mockk
import io.mockk.verify
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class IntegrateTest {

    fun createUser(email:String, userId:Int, userType: UserType, db: Database): User {
        val user = User(userId,email,userType)
        db.saveUser(user)
        return user
    }

    fun createCompany(domainName:String, numberOfEmployees:Int, db: Database){
        db.saveCompany(Company(domainName, numberOfEmployees))
    }
    @Test
    fun changing_email_from_corporate_to_non_corporate(){
        val db = Database()
        val user = createUser("user@mycorp.com",1,UserType.Employee,db)
        createCompany("mycorp.com",1,db)

        val messageBusMock = mockk<IMessageBus>(relaxed = true)
        val sut = UserController(db,messageBusMock)

        val result = sut.changeEmail(user.userId,"new@gmail.com")

        assertEquals("OK",result)

        val userData = db.getUserById(user.userId) ?: error("user not found")
        val userFromDb = UserFactory.create(userData)
        assertEquals("new@gmail.com",userFromDb.email)
        assertEquals(UserType.Customer,userFromDb.type)

        val companyData = db.getCompany() ?: error("company not found")
        val companyFromDb = CompanyFactory.create(companyData)
        assertEquals(0,companyFromDb.numberOfEmployees)

        verify(exactly = 1){messageBusMock.sendEmailChangedMessage(user.userId,"new@gmail.com")}

    }

}