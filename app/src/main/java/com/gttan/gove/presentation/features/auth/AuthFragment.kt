package com.gttan.gove.presentation.features.auth

import androidx.fragment.app.activityViewModels
import com.gttan.gove.databinding.FragmentAuthBinding
import com.gttan.gove.presentation.base.BaseFragment

class AuthFragment : BaseFragment<FragmentAuthBinding>() {

    private val viewModel: AuthViewModel by activityViewModels()

    override fun init() {
        // TODO:
    }

}
