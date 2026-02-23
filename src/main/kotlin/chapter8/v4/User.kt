package chapter8.v4

import chapter8.Company
import chapter8.ILogger
import chapter8.Precondition
import chapter8.UserType



class User (userId:Int, email:String, type: UserType, private val _logger: ILogger, isEmailConfirmed:Boolean = false, ){
    var userId:Int = userId
        private set
    var email:String = email
        private set
    var type:UserType = type
        private set
    var isEmailConfirmed:Boolean = isEmailConfirmed
        private set
    val domainEvents = mutableListOf<IDomainEvent>()



    fun canChangeEmail():String?{
        if(isEmailConfirmed) return "Email is already confirmed"
        return null
    }
    fun changeEmail(newEmail: String,company: Company){
        _logger.info("Changing email for user $userId to $newEmail")

        Precondition.requires(canChangeEmail()==null)
        if(this.email == newEmail) return
        val newType = if (company.isEmailCorporate(newEmail)) UserType.Employee else UserType.Customer

        if(this.type != newType){
            val delta = if(newType == UserType.Employee) 1 else -1
            company.changeNumberOfEmployees(delta)
            domainEvents.add(UserTypeChangedEvent(userId, this.type, newType))
        }

        this.email = newEmail
        this.type = newType
        domainEvents.add(EmailChangedEvent(userId, newEmail))

        _logger.info("Email changed for user $userId")

    }
}