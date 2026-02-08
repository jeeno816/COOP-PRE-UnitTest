package chapter7.v3

import chapter7.UserType

class UserController {
    private val _database = Database()
    private val _messageBus = MessageBus()

    fun changeEmail(userId:Int,newEmail:String){
        val data = _database.getUserById(userId) ?: return
        val user = UserFactory.create(data)

        val companyData = _database.getCompany() ?: return
        val companyDomainName = companyData[0] as String
        val numberOfEmployees = companyData[1] as Int

        val newNumberOfEmployees = user.changeEmail(newEmail,companyDomainName,numberOfEmployees)

        _database.saveCompany(newNumberOfEmployees)
        _database.saveUser(user)
        _messageBus.sendEmailChangedMessage(userId,newEmail)
    }
}