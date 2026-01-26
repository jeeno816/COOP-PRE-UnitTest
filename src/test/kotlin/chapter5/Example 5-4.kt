package chapter5

import chapter2.*
import io.mockk.*
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class `Example 5-4` {

    @Test
    fun purchase_fails_when_not_enough_inventory(){
        val storeMock = mockk<IStore>()
        every{ storeMock.hasEnoughInventory(Product.Shampoo,5) } returns false
        val sut = Customer()

        val success = sut.purchase(storeMock,Product.Shampoo,5)

        assertFalse(success)
        verify(exactly = 0){storeMock.removeInventory(Product.Shampoo,5)}


    }
}