package com.warriorsacred.masq.fragments.categories

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.warriorsacred.masq.R
import com.warriorsacred.masq.adapters.ProductAdapter
import com.warriorsacred.masq.data.Product
import com.warriorsacred.masq.network.ApiClient
import com.warriorsacred.masq.viewmodel.MainCategoryViewModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class MainCategoryFragment : Fragment(R.layout.fragment_main_category) {
    private lateinit var mainCategoryViewModel: MainCategoryViewModel
    private lateinit var recyclerView: RecyclerView
    private lateinit var productAdapter: ProductAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_main_category, container, false)
        recyclerView = view.findViewById(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(requireContext())
        recyclerView.setHasFixedSize(true)

        mainCategoryViewModel = ViewModelProvider(this).get(MainCategoryViewModel::class.java)
        productAdapter = ProductAdapter(requireContext(), mainCategoryViewModel.getProductList().value ?: emptyList())
        recyclerView.adapter = productAdapter

        mainCategoryViewModel.getProductList().observe(viewLifecycleOwner, { products ->
            productAdapter.updateList(products)
        })

        return view
    }
}