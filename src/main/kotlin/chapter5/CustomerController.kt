package chapter5

import chapter2.Store

class CustomerController(val _emailGateway: IEmailGateway) {
    val _customerRepository = CustomerRepository()
    val _productRepository = ProductRepository()
    var _mainStore = Store()

    fun purchase(customerId:Int,productId:Int,quantity:Int):Boolean{
        val customer = _customerRepository.getById(customerId)
        val product = _productRepository.getById(productId)

        val isSuccess = customer.purchase(_mainStore,product,quantity)

        if (isSuccess){
            _emailGateway.sendReceipt(customer.email,product.name,quantity)
        }
        return isSuccess
    }
}