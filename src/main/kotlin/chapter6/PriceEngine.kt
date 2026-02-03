package chapter6

import kotlin.math.min

class PriceEngine {
    fun calculateDiscount(vararg products: Product): Double{
        val discount = products.size.toDouble() * 0.01
        return min(discount,0.2)
    }
}