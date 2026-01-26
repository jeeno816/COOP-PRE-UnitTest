package chapter2

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class PurchaseTest {
    @Test
    fun example2_1_enough(){
        val store = Store()
        store.addInventory(Product.Shampoo,10)
        val customer = Customer()

        val success = customer.purchase(store,Product.Shampoo,5)

        assertTrue(success)
        assertEquals(5,store.getInventory(Product.Shampoo))

    }

    @Test
    fun example2_1_notEnough(){
        val store = Store()
        store.addInventory(Product.Shampoo,10)
        val customer = Customer()

        val success = customer.purchase(store,Product.Shampoo,15)

        assertFalse(success)
        assertEquals(10,store.getInventory(Product.Shampoo))
    }




}