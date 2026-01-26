package chapter2

import org.junit.jupiter.api.Assertions.assertFalse
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.mockito.BDDMockito.given
import org.mockito.BDDMockito.then
import org.mockito.Mock
import org.mockito.Mockito.never
import org.mockito.Mockito.times
import org.mockito.junit.jupiter.MockitoExtension

@ExtendWith(MockitoExtension::class)
class LondonTest {
    @Mock lateinit var storeMock: IStore

    @Test
    fun purchase_success(){
        given(storeMock.hasEnoughInventory(Product.Shampoo,5)).willReturn(true)
        val customer = Customer()

        val success = customer.purchase(storeMock,Product.Shampoo,5)

        assertTrue(success)
        then(storeMock).should(times(1)).removeInventory(Product.Shampoo,5)
    }

    @Test
    fun purchase_fail(){
        given(storeMock.hasEnoughInventory(Product.Shampoo,5)).willReturn(false)
        val customer = Customer()

        val success = customer.purchase(storeMock,Product.Shampoo,5)

        assertFalse(success)
        then(storeMock).should(never()).removeInventory(Product.Shampoo,5)
    }
}