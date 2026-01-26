package chapter3


import org.junit.jupiter.api.Assertions.assertNotNull
import org.junit.jupiter.api.Test

class `Example 3-9` : IntegrationTests() {

    @Test
    fun purchase_succeeds_when_enough_inventory(){
        assertNotNull(_database)
    }
}