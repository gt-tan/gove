package com.gttan.gove.presentation.features.splash

import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.navigation.fragment.findNavController
import com.gttan.gove.databinding.FragmentSplashBinding
import com.gttan.gove.presentation.base.BaseFragment
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class SplashFragment : BaseFragment<FragmentSplashBinding>() {

    private val viewModel: SplashViewModel by activityViewModels()

    override fun init() {
        lifecycleScope.launch {
            viewLifecycleOwner.repeatOnLifecycle(Lifecycle.State.STARTED) {
                viewModel.viewState.collect { viewState ->
                    when (viewState) {
                        SplashViewEvent.Loading -> {}
                        SplashViewEvent.ToOnBoardingFragment -> {
                            findNavController().navigate(
                                SplashFragmentDirections.actionSplashFragmentToOnBoardingFragment()
                            )
                        }

                        SplashViewEvent.ToAuthFragment -> {
                            findNavController().navigate(
                                SplashFragmentDirections.actionSplashFragmentToAuthFragment()
                            )
                        }

                        SplashViewEvent.ToMainFragment -> {
                            findNavController().navigate(
                                SplashFragmentDirections.actionSplashFragmentToProductsFragment()
                            )
                        }
                    }
                }
            }
        }
    }

}
