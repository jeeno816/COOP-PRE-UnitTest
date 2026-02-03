package chapter6

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test


class `Example 6-1` {
    @Test
    fun discount_of_two_products(){
        val product1 = Product("Hand wash")
        val product2 = Product("Shampoo")
        val sut = PriceEngine()

        val discount = sut.calculateDiscount(product1,product2)

        assertEquals(0.02,discount)

    }
}