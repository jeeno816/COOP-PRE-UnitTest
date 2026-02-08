package chapter7.v7

import chapter7.UserType

object CompanyFactory {
    fun create(data:Array<Any?>):Company{
        Precondition.requires(data.size>=2)

        val domainName = data[0] as String
        val numberOfEmployees = data[1] as Int

        return Company(domainName,numberOfEmployees)
    }
}