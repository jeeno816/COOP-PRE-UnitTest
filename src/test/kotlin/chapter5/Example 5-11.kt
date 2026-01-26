package chapter5

import chapter2.*
import io.mockk.*
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class `Example 5-11` {

    @Test
    fun purchase_succeeds_when_enough_inventory(){
        val storeMock = mockk<IStore>(relaxed = true)
        every{ storeMock.hasEnoughInventory(Product.Shampoo,5) } returns true
        val customer = Customer()

        val success = customer.purchase(storeMock,Product.Shampoo,5)

        assertTrue(success)
        verify(exactly = 1){storeMock.removeInventory(Product.Shampoo,5)}





    }

}