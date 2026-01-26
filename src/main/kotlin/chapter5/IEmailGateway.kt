package chapter5

interface IEmailGateway {
    fun sendGreetingsEmail(mail: String)
    fun sendReceipt(email:String,productName:String,quantity:Int)
}