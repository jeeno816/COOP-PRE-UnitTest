package chapter3

import chapter2.Customer
import chapter2.Product
import chapter2.Store
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test

class `Example 3-3` {
    @Test
    fun purchase_succeeds_when_enough_inventory(){
        //준비
        val store = Store()
        store.addInventory(Product.Shampoo,10)
        val customer = Customer()

        //실행
        val success = customer.purchase(store,Product.Shampoo,5)
        //store.removeInventory(Product.Shampoo,5)

        //검증
        assertTrue(success)
        assertEquals(5,store.getInventory(Product.Shampoo))

    }
}