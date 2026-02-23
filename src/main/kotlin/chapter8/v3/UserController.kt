package chapter8.v3

import chapter8.CompanyFactory
import chapter8.Database
import chapter8.IMessageBus
import chapter8.MessageBus
import chapter8.UserFactory

class UserController(private val _database: Database = Database(),
                     private val _messageBus: IMessageBus = MessageBus()
) {

    fun changeEmail(userId:Int,newEmail:String):String{
        val data = _database.getUserById(userId) ?: return "User not found"
        val user = UserFactory.create(data)

        val error = user.canChangeEmail()
        if(error!=null)return "error"

        val companyData = _database.getCompany() ?: return "Company not found"
        val company = CompanyFactory.create(companyData)

        user.changeEmail(newEmail,company)

        _database.saveCompany(company)
        _database.saveUser(user)
        user.emailChangedEvents.forEach { event -> _messageBus.sendEmailChangedMessage(event.userId,event.newEmail) }
        return "OK"
    }
}