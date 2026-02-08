package chapter7.v3

import chapter7.UserType


class User (userId:Int,email:String,type:UserType){
    var userId:Int = userId
        private set
    var email:String = email
        private set
    var type:UserType = type
        private set

    fun changeEmail(newEmail: String,companyDomainName:String,numberOfEmployees:Int):Int{
        if(this.email == newEmail) return numberOfEmployees

        val emailDomain = newEmail.substringAfter("@")
        val isEmailCorporate = emailDomain == companyDomainName
        val newType = if (isEmailCorporate) UserType.Employee else UserType.Customer
        var numberOfEmployees = numberOfEmployees
        if(this.type != newType){
            val delta = if(newType == UserType.Employee) 1 else -1
            val newNumber = numberOfEmployees + delta
            numberOfEmployees = newNumber
        }

        this.email = newEmail
        this.type = newType

        return numberOfEmployees
    }
}