package com.gttan.gove.presentation.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.gttan.gove.databinding.ItemCartBinding
import com.gttan.gove.domain.model.CartItem
import com.gttan.gove.presentation.util.setPrice
import com.gttan.gove.presentation.util.setProductImage

class CartAdapter(
    val onIncrease: (CartItem) -> Unit,
    val onDecrease: (CartItem) -> Unit,
) : ListAdapter<CartItem, CartAdapter.CartViewHolder>(ProductsDiffUtil()) {

    inner class CartViewHolder(
        private val binding: ItemCartBinding
    ) : RecyclerView.ViewHolder(binding.root) {

        fun bind(cartItem: CartItem) {
            with(binding) {
                imageProduct setProductImage cartItem.product.image
                textProductTitle.text = cartItem.product.title
                textProductPrice setPrice cartItem.product.price * cartItem.amount

                amountView.amount = cartItem.amount
                amountView.buttonIncrease.setOnClickListener {
                    onIncrease(cartItem)
                }

                amountView.buttonDecrease.setOnClickListener {
                    onDecrease(cartItem)
                }
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CartViewHolder {
        val binding = ItemCartBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return CartViewHolder(binding)
    }

    override fun onBindViewHolder(holder: CartViewHolder, position: Int) {
        val product = getItem(position)
        holder.bind(product)
    }

    class ProductsDiffUtil : DiffUtil.ItemCallback<CartItem>() {
        override fun areItemsTheSame(oldItem: CartItem, newItem: CartItem) =
            oldItem.product.id == oldItem.product.id

        override fun areContentsTheSame(oldItem: CartItem, newItem: CartItem) = oldItem == newItem
    }
}
