package chapter7.v1

import chapter7.UserType

class User {
    var userId:Int = 0
        private set
    var email:String = ""
        private set
    var type:UserType = UserType.Customer
        private set

    fun changeEmail(userId: Int, newEmail: String){
        val data = Database.getUserById(userId) ?: return
        this.userId = userId
        this.email = data[1] as String
        this.type = data[2] as UserType

        if(this.email == newEmail) return

        val companyData = Database.getCompany()?:return
        val companyDomainName = companyData[0] as String
        val numberOfEmployees = companyData[1] as Int

        val emailDomain = newEmail.substringAfter("@")
        val isEmailCorporate = emailDomain == companyDomainName
        val newType = if (isEmailCorporate) UserType.Employee else UserType.Customer

        if(this.type != newType){
            val delta = if(newType == UserType.Employee) 1 else -1
            val newNumber = numberOfEmployees + delta
            Database.saveCompany(newNumber)
        }

        this.email = newEmail
        this.type = newType

        Database.saveUser(this)
        MessageBus.sendEmailChangedMessage(userId,newEmail)
    }
}