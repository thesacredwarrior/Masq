package com.warriorsacred.masq.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.warriorsacred.masq.data.Product
import com.warriorsacred.masq.network.ApiClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainCategoryViewModel : ViewModel() {
    private val productList: MutableLiveData<List<Product>> = MutableLiveData()

    init {
        loadProducts()
    }

    fun getProductList(): LiveData<List<Product>> {
        return productList
    }

    private fun loadProducts() {
        ApiClient.api.getMensClothing().enqueue(object : Callback<List<Product>> {
            override fun onResponse(call: Call<List<Product>>, response: Response<List<Product>>) {
                if (response.isSuccessful) {
                    val products = response.body()
                    if (products != null) {
                        productList.value = products!!
                        Log.d("MainCategoryFragment", "Received ${productList.value?.size} products")
                    } else {
                        Log.d("MainCategoryFragment", "Empty product list")
                    }
                }
            }

            override fun onFailure(call: Call<List<Product>>, t: Throwable) {
                Log.d("MainCategoryFragment", "API request failed")
            }
        })
    }
}