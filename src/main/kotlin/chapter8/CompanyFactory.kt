package chapter8

object CompanyFactory {
    fun create(data:Array<Any?>):Company{
        Precondition.requires(data.size>=2)

        val domainName = data[0] as String
        val numberOfEmployees = data[1] as Int

        return Company(domainName,numberOfEmployees)
    }
}