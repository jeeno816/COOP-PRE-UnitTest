package chapter3

import chapter2.Customer
import chapter2.Product
import chapter2.Store
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertFalse
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test

class `Example 3-7` {
    val _store = Store()
    val _sut = Customer()

    init{
        _store.addInventory(Product.Shampoo,10)
    }


    @Test
    fun purchase_succeeds_when_enough_inventory(){
        val success = _sut.purchase(_store,Product.Shampoo,5)
        assertTrue(success)
        assertEquals(5,_store.getInventory(Product.Shampoo))
    }

    @Test
    fun purchase_fails_when_not_enough_inventory(){
        val success = _sut.purchase(_store,Product.Shampoo,15)
        assertFalse(success)
        assertEquals(10,_store.getInventory(Product.Shampoo))
    }
}