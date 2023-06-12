package com.warriorsacred.masq.repository

import com.warriorsacred.masq.data.Product
import com.warriorsacred.masq.network.ApiService
import retrofit2.Call

class ProductRepository(private val productService: ApiService) {

    fun getProducts(): Call<List<Product>> {
        return productService.getMensClothing()
    }
}