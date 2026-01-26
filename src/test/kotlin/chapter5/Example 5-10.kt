package chapter5

import chapter2.*
import io.mockk.*
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class `Example 5-10` {

    @Test
    fun successful_purchase(){
        val mock = mockk<IEmailGateway>(relaxed = true)
        val sut = CustomerController(mock)
        sut._mainStore.addInventory(Product.Shampoo,10)

        val isSuccess = sut.purchase(1,2,5)

        assertTrue(isSuccess)
        verify(exactly = 1){mock.sendReceipt("customer@email.com","Shampoo",5)}



    }

}