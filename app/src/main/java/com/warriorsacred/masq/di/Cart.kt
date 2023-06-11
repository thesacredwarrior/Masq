package com.warriorsacred.masq.di

import com.warriorsacred.masq.data.Product

object Cart {
    private val items = mutableListOf<Product>()

    fun addItem(item: Product) {
        items.add(item)
    }

    fun removeItem(item: Product) {
        items.remove(item)
    }

    fun removeItemAt(index: Int) {
        items.removeAt(index)
    }

    fun getItems(): List<Product> {
        return items
    }
}
