package chapter8

interface IDomainLogger{
    fun userTypeHasChanged(userId:Int,oldType: UserType,newType: UserType)
}