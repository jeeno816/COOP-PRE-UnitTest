package chapter7.v7

import chapter7.UserType

class UserController {
    private val _database = Database()
    private val _messageBus = MessageBus()

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
        _messageBus.sendEmailChangedMessage(userId,newEmail)
        return "OK"
    }
}