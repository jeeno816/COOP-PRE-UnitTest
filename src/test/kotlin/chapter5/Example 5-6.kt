package chapter5


class `Example 5-6` {

    class User{
        private var _name = ""
        var name:String
            get() = _name
            set(value){ _name = normalizeName(value)}
        private fun normalizeName(name:String):String{
            val result = name.trim()

            if (result.length > 50)return result.substring(0..49)
            return result
        }
    }

    class UserController{
        fun renameUser(userId:Int,newName:String){
            val user = getUserFromDatabase(userId)
            user.name = newName

            saveUserToDatabase(user)

        }
        fun getUserFromDatabase(userId:Int)=User()
        fun saveUserToDatabase(user:User){}
    }

}