package com.gttan.gove.presentation.features.products

import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.navigation.fragment.findNavController
import com.gttan.gove.databinding.FragmentProductsBinding
import com.gttan.gove.presentation.adapter.ProductAdapter
import com.gttan.gove.presentation.base.BaseFragment
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class ProductsFragment : BaseFragment<FragmentProductsBinding>() {

    // 关于viewModels()和activityViewModels()
    // viewModels()只维护单个fragment的状态,比如多次创建该Fragment,它们之间的ViewModel是不共享的
    // 而activityViewModels(),在该Fragment多次创建销毁时,ViewModel始终只存在一个对象,状态保留

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
                        binding.progressIndicator.show()
                    } else {
                        productAdapter.submitList(state.products)
                        binding.progressIndicator.hide()
                    }
                }
            }
        }
    }

}
