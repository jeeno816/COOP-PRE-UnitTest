package chapter5


class `Example 5-5` {

    class User{
        var name = ""
        fun normalizeName(name:String):String{
            val result = name.trim()

            if (result.length > 50)return result.substring(0..49)
            return result
        }
    }

    class UserController{
        fun renameUser(userId:Int,newName:String){
            val user = getUserFromDatabase(userId)

            val normalizedName = user.normalizeName(newName)
            user.name = normalizedName

            saveUserToDatabase(user)

        }
        fun getUserFromDatabase(userId:Int)=User()
        fun saveUserToDatabase(user:User){}
    }

}