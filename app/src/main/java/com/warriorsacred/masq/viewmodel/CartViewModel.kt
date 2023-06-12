package com.warriorsacred.masq.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.warriorsacred.masq.data.Product
import com.warriorsacred.masq.di.Cart

class CartViewModel : ViewModel() {
    private val cart: Cart = Cart

    fun getProductList(): LiveData<List<Product>> {
        return MutableLiveData(Cart.getItems())
    }

    fun removeProduct(position: Int) {
        val productList = cart.getItems()
        if (position in productList.indices) {
            val productToRemove = productList[position]
            cart.removeItem(productToRemove)
        }
    }

}