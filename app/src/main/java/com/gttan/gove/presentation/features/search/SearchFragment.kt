package com.gttan.gove.presentation.features.search

import androidx.core.widget.doAfterTextChanged
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.navigation.fragment.findNavController
import com.gttan.gove.databinding.FragmentSearchBinding
import com.gttan.gove.presentation.adapter.CategoryAdapter
import com.gttan.gove.presentation.adapter.ProductAdapter
import com.gttan.gove.presentation.base.BaseFragment
import kotlinx.coroutines.launch

class SearchFragment : BaseFragment<FragmentSearchBinding>() {

    private val viewModel: SearchViewModel by activityViewModels()

    private val categoryAdapter = CategoryAdapter { category ->
        viewModel.selectFilter(category)
    }

    private val productAdapter = ProductAdapter { product ->
        val action =
            SearchFragmentDirections.actionSearchFragmentToProductDetailFragment(product.id)
        findNavController().navigate(action)
    }

    override fun init() {
        viewLifecycleOwner.lifecycleScope.launch {
            viewLifecycleOwner.repeatOnLifecycle(Lifecycle.State.STARTED) {
                viewModel.state.collect { state ->
                    categoryAdapter.submitList(state.categories).also {
                        binding.recyclerViewProducts.smoothScrollToPosition(0)
                    }
                    productAdapter.submitList(
                        viewModel.getFilteredList(state)
                    ).also {
                        binding.recyclerViewProducts.smoothScrollToPosition(0)
                    }
                }
            }
        }

        binding.apply {
            editTextSearch.doAfterTextChanged { query ->
                viewModel.setQuery(query.toString())
            }
            recyclerViewCategories.adapter = categoryAdapter
            recyclerViewProducts.adapter = productAdapter
        }
    }

}
