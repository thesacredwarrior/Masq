package com.warriorsacred.masq.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.warriorsacred.masq.data.Product
import com.warriorsacred.masq.repository.ProductRepository
import kotlinx.coroutines.launch

class ProductViewModel(private val productRepository: ProductRepository) : ViewModel() {

    private val _products = MutableLiveData<List<Product>>()
    val products: LiveData<List<Product>> = _products

    fun loadProducts() {
        viewModelScope.launch {
            val response = productRepository.getProducts().execute()
            if (response.isSuccessful) {
                _products.value = response.body()
            } else {
                Log.d("ProductViewModel", "Error")
            }
        }
    }
}