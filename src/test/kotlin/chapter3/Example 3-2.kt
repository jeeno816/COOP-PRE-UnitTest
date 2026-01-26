package chapter3

import chapter2.Customer
import chapter2.Product
import chapter2.Store
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class `Example 3-2` {
    @Test
    fun purchase_succeds_when_enough_inventory(){
        //준비
        val store = Store()
        store.addInventory(Product.Shampoo,10)
        val customer = Customer()

        //실행
        val success = customer.purchase(store,Product.Shampoo,5)

        //검증
        assertEquals(true,success)
        assertEquals(5,store.getInventory(Product.Shampoo))

    }
}