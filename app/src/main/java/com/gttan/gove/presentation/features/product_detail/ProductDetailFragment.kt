package com.gttan.gove.presentation.features.product_detail

import androidx.fragment.app.activityViewModels
import com.gttan.gove.databinding.FragmentProductDetailBinding
import com.gttan.gove.presentation.base.BaseFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ProductDetailFragment : BaseFragment<FragmentProductDetailBinding>() {

    private val viewModel: ProductDetailViewModel by activityViewModels()

    override fun init() {
        // TODO:
    }

}
