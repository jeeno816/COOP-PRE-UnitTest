package chapter2

class Store:IStore {
    val inventory = mutableMapOf<Product,Int>()
    override fun hasEnoughInventory(product: Product, quantity: Int): Boolean {
        return inventory[product]!! >= quantity
    }
    override fun removeInventory(product: Product, quantity: Int) {
        inventory[product] = inventory[product]!! - quantity
    }
    override fun addInventory(product: Product, quantity: Int) {
        inventory[product] = inventory.getOrPut(product) { 0 } + quantity
    }
    override fun getInventory(product: Product): Int {
        return inventory[product]!!
    }
}