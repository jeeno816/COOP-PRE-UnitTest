package chapter3

abstract class IntegrationTests {
    val _database:Database = Database()
    fun dispose(){_database.dispose()}

}