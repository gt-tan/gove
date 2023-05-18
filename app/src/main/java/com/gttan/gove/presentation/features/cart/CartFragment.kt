package com.gttan.gove.presentation.features.cart

import androidx.fragment.app.activityViewModels
import com.gttan.gove.databinding.FragmentCartBinding
import com.gttan.gove.presentation.base.BaseFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class CartFragment : BaseFragment<FragmentCartBinding>() {

    private val viewModel: CartViewModel by activityViewModels()

    override fun init() {
        // TODO:  
    }

}
