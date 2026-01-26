package chapter5

class Controller {
    var emailGateway: IEmailGateway? = null
    var database: IDatabase? = null

    constructor(emailGateway: IEmailGateway) {
        this.emailGateway = emailGateway
    }

    constructor(database: IDatabase) {
        this.database = database
    }

    fun greetUser(userEmail: String) {
        emailGateway?.sendGreetingsEmail(userEmail)
    }

    fun createReport(): Report? {
        val numberOfUsers = database?.getNumberOfUsers() ?: return null
        return Report(numberOfUsers)
    }
}