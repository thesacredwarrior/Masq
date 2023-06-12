package com.warriorsacred.masq.adapters


import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.warriorsacred.masq.R
import com.warriorsacred.masq.data.Product
import com.warriorsacred.masq.di.Cart


class ProductAdapter(
    private val context: Context,
    private var productList: List<Product>
) : RecyclerView.Adapter<ProductAdapter.ProductViewHolder>() {

    fun updateList(newList: List<Product>) {
        productList = newList
        notifyDataSetChanged()
    }



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.item_product, parent, false)
        return ProductViewHolder(view)
    }

    override fun onBindViewHolder(holder: ProductViewHolder, position: Int) {
        val product = productList[position]
        holder.title.text = product.title
        holder.price.text = "$${product.price}"
        Glide.with(context).load(product.image).into(holder.image)

        holder.addToCartButton.setOnClickListener {
            Cart.addItem(product)
            Toast.makeText(context, "Товар добавлен в корзину", Toast.LENGTH_SHORT).show()
        }
    }


    override fun getItemCount(): Int {
        return productList.size
    }

    inner class ProductViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val image: ImageView = itemView.findViewById(R.id.product_image)
        val title: TextView = itemView.findViewById(R.id.product_title)
        val price: TextView = itemView.findViewById(R.id.product_price)
        val addToCartButton: Button = itemView.findViewById(R.id.add_to_cart_button)
    }

}