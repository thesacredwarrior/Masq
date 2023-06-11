package com.warriorsacred.masq.fragments.shopping

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.warriorsacred.masq.R
import com.warriorsacred.masq.adapters.CartProductAdapter
import com.warriorsacred.masq.data.Product
import com.warriorsacred.masq.di.Cart
import com.warriorsacred.masq.helper.OnRemoveProductClickListener

class CartFragment : Fragment(R.layout.fragment_cart), OnRemoveProductClickListener {
    private lateinit var cartAdapter: CartProductAdapter
    private lateinit var productList: MutableList<Product>

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val recyclerView = view.findViewById<RecyclerView>(R.id.cart_recycler_view)
        productList = Cart.getItems().toMutableList()
        cartAdapter = CartProductAdapter(requireContext(), productList, this)
        recyclerView.adapter = cartAdapter
        recyclerView.layoutManager = LinearLayoutManager(requireContext())
    }

    override fun onRemoveProduct(position: Int) {
        productList.removeAt(position)
        Cart.removeItemAt(position)
        cartAdapter.notifyItemRemoved(position)
    }
}
