package chapter7.v8

class Company(domainName:String,numberOfEmployees:Int) {
    var domainName:String = domainName
        private set
    var numberOfEmployees:Int = numberOfEmployees
        private set

    fun changeNumberOfEmployees(delta:Int){
        Precondition.requires(numberOfEmployees + delta >= 0)
        numberOfEmployees += delta
    }

    fun isEmailCorporate(email:String):Boolean{
        return email.substringAfter("@") == domainName
    }
}