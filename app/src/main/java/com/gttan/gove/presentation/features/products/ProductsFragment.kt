package com.gttan.gove.presentation.features.products

import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.navigation.fragment.findNavController
import com.gttan.gove.databinding.FragmentProductsBinding
import com.gttan.gove.presentation.adapter.ProductAdapter
import com.gttan.gove.presentation.base.BaseFragment
import kotlinx.coroutines.launch

class ProductsFragment : BaseFragment<FragmentProductsBinding>() {

    private val viewModel: ProductsViewModel by activityViewModels()

    private val productAdapter = ProductAdapter { product ->
        val action =
            ProductsFragmentDirections.actionProductsFragmentToProductDetailFragment(product.id)
        findNavController().navigate(action)
    }

    override fun init() {
        with(binding) {
            recyclerViewProducts.adapter = productAdapter
        }

        viewLifecycleOwner.lifecycleScope.launch {
            viewLifecycleOwner.repeatOnLifecycle(Lifecycle.State.STARTED) {
                viewModel.state.collect { state ->
                    if (state.isLoading) {
                        // TODO:
                    } else {
                        productAdapter.submitList(state.products)
                    }
                }
            }
        }
    }

}
