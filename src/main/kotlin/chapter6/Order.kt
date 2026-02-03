package chapter6

class Order {
    private val _products = mutableListOf<Product>()
    val products
        get() = _products.toList()

    fun addProduct(product:Product){
        _products.add(product)
    }
}