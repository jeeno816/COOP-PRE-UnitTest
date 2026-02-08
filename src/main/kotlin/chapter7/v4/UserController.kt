package chapter7.v4

import chapter7.UserType

class UserController {
    private val _database = Database()
    private val _messageBus = MessageBus()

    fun changeEmail(userId:Int,newEmail:String){
        val data = _database.getUserById(userId) ?: return
        val user = UserFactory.create(data)

        val companyData = _database.getCompany() ?: return
        val company = CompanyFactory.create(companyData)

        user.changeEmail(newEmail,company)

        _database.saveCompany(company)
        _database.saveUser(user)
        _messageBus.sendEmailChangedMessage(userId,newEmail)
    }
}