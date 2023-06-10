package com.warriorsacred.masq.fragments.categories

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.warriorsacred.masq.R
import com.warriorsacred.masq.adapters.ProductAdapter
import com.warriorsacred.masq.data.Product
import com.warriorsacred.masq.network.ApiClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class MainCategoryFragment : Fragment(R.layout.fragment_main_category) {

    private lateinit var recyclerView: RecyclerView
    private lateinit var productAdapter: ProductAdapter
    private var productList: List<Product> = emptyList()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_main_category, container, false)
        recyclerView = view.findViewById(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(requireContext())
        recyclerView.setHasFixedSize(true)

        // Инициализация адаптера с пустым списком товаров
        productAdapter = ProductAdapter(requireContext(), productList)
        recyclerView.adapter = productAdapter

        loadProducts()

        return view
    }


    private fun loadProducts() {
        ApiClient.api.getMensClothing().enqueue(object : Callback<List<Product>> {
            override fun onResponse(call: Call<List<Product>>, response: Response<List<Product>>) {
                if (response.isSuccessful) {
                    val products = response.body()
                    if (products != null) {
                        productList = products
                        Log.d("MainCategoryFragment", "Received ${productList.size} products")
                        productAdapter = ProductAdapter(requireContext(), productList)
                        recyclerView.adapter = productAdapter
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