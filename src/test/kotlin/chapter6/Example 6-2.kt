package chapter6

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test


class `Example 6-2` {
    @Test
    fun adding_a_product_to_an_order(){
        val product= Product("Hand wash")
        val sut= Order()

        sut.addProduct(product)

        assertEquals(1,sut.products.size)
        assertEquals(product,sut.products[0])

    }
}