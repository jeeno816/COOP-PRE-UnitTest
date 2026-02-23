package chapter8

import chapter8.v1.User

class Database {
    // In-memory storage for simplicity in tests/examples
    private val users: MutableMap<Int, Array<Any?>> = mutableMapOf()
    private var companyData: Array<Any?>? = null

    fun getUserById(userId: Int): Array<Any?>? = users[userId]

    fun getCompany(): Array<Any?>? = companyData

    fun saveCompany(company: Company) {
        companyData = arrayOf(company.domainName, company.numberOfEmployees)
    }

    fun saveUser(user: User) {
        users[user.userId] = arrayOf(user.userId, user.email, user.type, user.isEmailConfirmed)
    }
}