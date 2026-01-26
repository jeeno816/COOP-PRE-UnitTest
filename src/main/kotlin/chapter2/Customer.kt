package chapter2

class Customer {

    fun purchase(store: IStore , product: Product, quantity: Int): Boolean{
        if(!store.hasEnoughInventory(product,quantity)) return false
        store.removeInventory(product,quantity)
        return true
    }
}