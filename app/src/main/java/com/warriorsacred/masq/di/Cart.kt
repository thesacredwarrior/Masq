package com.warriorsacred.masq.di

import com.warriorsacred.masq.data.Product

object Cart {
    private val productList: MutableList<Product> = mutableListOf()

    fun addItem(product: Product) {
        productList.add(product)
    }

    fun removeItem(product: Product) {
        productList.remove(product)
    }

    fun removeItemAt(position: Int) {
        if (position in 0 until productList.size) {
            productList.removeAt(position)
        }
    }

    fun getItems(): List<Product> {
        return productList
    }
}
