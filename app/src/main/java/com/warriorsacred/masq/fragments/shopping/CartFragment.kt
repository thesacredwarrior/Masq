package com.warriorsacred.masq.fragments.shopping

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.warriorsacred.masq.R
import com.warriorsacred.masq.adapters.CartProductAdapter
import com.warriorsacred.masq.data.Product
import com.warriorsacred.masq.helper.OnRemoveProductClickListener
import com.warriorsacred.masq.viewmodel.CartViewModel

class CartFragment : Fragment(R.layout.fragment_cart), OnRemoveProductClickListener {
    private lateinit var cartViewModel: CartViewModel
    private lateinit var cartAdapter: CartProductAdapter
    private lateinit var productList: MutableList<Product>

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val recyclerView = view.findViewById<RecyclerView>(R.id.cart_recycler_view)
        productList = mutableListOf() // Initialize the productList

        cartViewModel = ViewModelProvider(this).get(CartViewModel::class.java)
        cartAdapter = CartProductAdapter(requireContext(), cartViewModel.getProductList().value ?: emptyList(), this)
        recyclerView.adapter = cartAdapter
        recyclerView.layoutManager = LinearLayoutManager(requireContext())

        cartViewModel.getProductList().observe(viewLifecycleOwner, { products ->
            cartAdapter.updateList(products)
        })
    }

    override fun onRemoveProduct(position: Int) {
        cartViewModel.removeProduct(position)
        cartAdapter.notifyItemRemoved(position)
        cartAdapter.notifyItemRangeChanged(position, productList.size)
    }

}
