package chapter8.v1

import chapter8.Company
import chapter8.Precondition
import chapter8.UserType


class User (userId:Int, email:String, type: UserType, isEmailConfirmed:Boolean = false){
    var userId:Int = userId
        private set
    var email:String = email
        private set
    var type:UserType = type
        private set
    var isEmailConfirmed:Boolean = isEmailConfirmed
        private set
    val emailChangedEvents = mutableListOf<EmailChangedEvent>()

    fun canChangeEmail():String?{
        if(isEmailConfirmed) return "Email is already confirmed"
        return null
    }
    fun changeEmail(newEmail: String,company: Company){
        Precondition.requires(canChangeEmail()==null)
        if(this.email == newEmail) return
        val newType = if (company.isEmailCorporate(newEmail)) UserType.Employee else UserType.Customer

        if(this.type != newType){
            val delta = if(newType == UserType.Employee) 1 else -1
            company.changeNumberOfEmployees(delta)
        }

        this.email = newEmail
        this.type = newType
        emailChangedEvents.add(EmailChangedEvent(userId, newEmail))

    }
}