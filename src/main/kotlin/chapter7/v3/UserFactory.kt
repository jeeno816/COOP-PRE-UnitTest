package chapter7.v3

import chapter7.UserType

object UserFactory {
    fun create(data:Array<Any?>):User{
        Precondition.requires(data.size>=3)

        val id = data[0] as Int
        val email = data[1] as String
        val type = data[2] as UserType

        return User(id,email,type)
    }
}