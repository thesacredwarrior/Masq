package com.warriorsacred.masq.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.warriorsacred.masq.R
import com.warriorsacred.masq.data.Product
import com.warriorsacred.masq.helper.OnRemoveProductClickListener

class CartProductAdapter(
    private val context: Context,
    private var productList: List<Product>,
    private val onRemoveProductClickListener: OnRemoveProductClickListener
) : RecyclerView.Adapter<CartProductAdapter.CartProductViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CartProductViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.item_cart_product, parent, false)
        return CartProductViewHolder(view)
    }

    override fun onBindViewHolder(holder: CartProductViewHolder, position: Int) {
        val product = productList[position]
        holder.title.text = product.title
        holder.price.text = "$${product.price}"
        Glide.with(context).load(product.image).into(holder.image)

        holder.removeButton.setOnClickListener {
            onRemoveProductClickListener.onRemoveProduct(position)
        }
    }

    override fun getItemCount(): Int {
        return productList.size
    }

    inner class CartProductViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val image: ImageView = itemView.findViewById(R.id.cart_product_image)
        val title: TextView = itemView.findViewById(R.id.cart_product_title)
        val price: TextView = itemView.findViewById(R.id.cart_product_price)
        val removeButton: Button = itemView.findViewById(R.id.cart_remove_button)
    }
}
