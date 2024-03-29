package com.gttan.gove.presentation.features.product_detail

import android.widget.Toast
import androidx.core.view.isVisible
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.navigation.fragment.findNavController
import com.gttan.gove.R
import com.gttan.gove.databinding.FragmentProductDetailBinding
import com.gttan.gove.presentation.base.BaseFragment
import com.gttan.gove.presentation.util.setPrice
import com.gttan.gove.presentation.util.setProductImage
import com.gttan.gove.presentation.util.setProductRating
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class ProductDetailFragment : BaseFragment<FragmentProductDetailBinding>() {

    private val viewModel: ProductDetailViewModel by viewModels()

    override fun init() {
        viewLifecycleOwner.lifecycleScope.launch {
            viewLifecycleOwner.repeatOnLifecycle(Lifecycle.State.STARTED) {
                viewModel.state.collect { state ->
                    with(binding) {
                        loadingIndicator.isVisible = state.isLoading
                        groupProductDetail.isVisible = !state.isLoading

                        state.product?.let { product ->
                            imageProduct setProductImage product.image
                            textProductRating setProductRating product.rating
                            textProductPrice setPrice product.price
                            ratingBarProduct.rating = product.rating.rate.toFloat()
                            textProductTitle.text = product.title
                            textProductDescription.text = product.description
                            textProductCategory.text = product.category
                        }

                        viewAddToCart.apply {
                            amount = state.amount
                            buttonIncrease.setOnClickListener {
                                viewModel.incrementAmount()
                            }
                            buttonDecrease.setOnClickListener {
                                viewModel.decrementAmount()
                            }
                            buttonAddToCart.setOnClickListener {
                                viewModel.addToCart(
                                    onSuccess = {
                                        Toast.makeText(
                                            requireContext(),
                                            resources.getString(R.string.toast_message_added_to_cart),
                                            Toast.LENGTH_SHORT
                                        ).show()
                                    }
                                )
                            }
                        }
                    }
                }
            }
        }

        with(binding) {
            toolbar.setNavigationOnClickListener {
                findNavController().popBackStack()
            }
        }
    }

}
