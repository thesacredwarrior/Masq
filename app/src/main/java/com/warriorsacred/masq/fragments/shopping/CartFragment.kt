package com.warriorsacred.masq.fragments.shopping

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.warriorsacred.masq.R
import com.warriorsacred.masq.adapters.CartProductAdapter
import com.warriorsacred.masq.di.Cart

class CartFragment : Fragment(R.layout.fragment_cart) {
    private lateinit var cartAdapter: CartProductAdapter

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val recyclerView = view.findViewById<RecyclerView>(R.id.cart_recycler_view)
        cartAdapter = CartProductAdapter(requireContext(), Cart.getItems())
        recyclerView.adapter = cartAdapter
        recyclerView.layoutManager = LinearLayoutManager(requireContext())
    }
}
