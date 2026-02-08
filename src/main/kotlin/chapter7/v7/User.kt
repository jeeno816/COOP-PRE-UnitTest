package chapter7.v7

import chapter7.UserType


class User (userId:Int,email:String,type:UserType){
    var userId:Int = userId
        private set
    var email:String = email
        private set
    var type:UserType = type
        private set
    var isEmailConfirmed:Boolean = false
        private set



    fun canChangeEmail():String?{
        if(isEmailConfirmed) return "Email is already confirmed"
        return null
    }
    fun changeEmail(newEmail: String,company:Company){
        Precondition.requires(canChangeEmail()==null)
        if(this.email == newEmail) return
        val newType = if (company.isEmailCorporate(newEmail)) UserType.Employee else UserType.Customer

        if(this.type != newType){
            val delta = if(newType == UserType.Employee) 1 else -1
            company.changeNumberOfEmployees(delta)
        }

        this.email = newEmail
        this.type = newType


    }
}