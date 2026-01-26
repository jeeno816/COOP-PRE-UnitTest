package chapter3

import chapter2.Customer
import chapter2.Product
import chapter2.Store
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertFalse
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test

class `Example 3-8` {

    @Test
    fun purchase_succeeds_when_enough_inventory(){
        val store = createStoreWithInventory(Product.Shampoo,10)
        val sut = createCustomer()
        val success = sut.purchase(store,Product.Shampoo,5)
        assertTrue(success)
        assertEquals(5,store.getInventory(Product.Shampoo))
    }

    @Test
    fun purchase_fails_when_not_enough_inventory(){
        val store = createStoreWithInventory(Product.Shampoo,10)
        val sut = createCustomer()
        val success = sut.purchase(store,Product.Shampoo,15)
        assertFalse(success)
        assertEquals(10,store.getInventory(Product.Shampoo))
    }

    fun createStoreWithInventory(product: Product,quantity: Int): Store {
        val store = Store()
        store.addInventory(product,quantity)
        return store
    }

    fun createCustomer()=Customer()
}