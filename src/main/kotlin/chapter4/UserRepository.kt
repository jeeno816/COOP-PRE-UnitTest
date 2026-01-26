package chapter4

class UserRepository {
    var lastExecutedSqlStatement:String = ""

    fun getById(id:Int):User{
        lastExecutedSqlStatement = "dummy sql"
        return User()
    }

}