package com.warriorsacred.masq.network


import com.warriorsacred.masq.data.Product
import retrofit2.Call
import retrofit2.http.GET

interface ApiService {
    @GET("products/category/men's%20clothing")
    fun getMensClothing(): Call<List<Product>>
}
