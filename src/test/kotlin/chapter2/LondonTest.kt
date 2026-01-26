package chapter2

import org.junit.jupiter.api.Assertions.assertFalse
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test
import io.mockk.*


class LondonTest {
    var storeMock = mockk<IStore>(relaxed = true)

    @Test
    fun purchase_success(){
        every { storeMock.hasEnoughInventory(Product.Shampoo,5) } returns true
        val customer = Customer()

        val success = customer.purchase(storeMock,Product.Shampoo,5)

        assertTrue(success)
        verify(exactly = 1){storeMock.removeInventory(Product.Shampoo,5)}
    }

    @Test
    fun purchase_fail(){
        every { storeMock.hasEnoughInventory(Product.Shampoo,5) } returns false
        val customer = Customer()

        val success = customer.purchase(storeMock,Product.Shampoo,5)

        assertFalse(success)
        verify(exactly = 0){storeMock.removeInventory(Product.Shampoo,5)}
    }
}