package com.gttan.gove.presentation.features.on_boarding

import android.os.Bundle
import androidx.core.view.isVisible
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import androidx.viewpager2.widget.ViewPager2
import com.gttan.gove.R
import com.gttan.gove.databinding.FragmentOnBoardingBinding
import com.gttan.gove.presentation.adapter.OnBoardingAdapter
import com.gttan.gove.presentation.base.BaseFragment

class OnBoardingFragment : BaseFragment<FragmentOnBoardingBinding>() {

    private val viewModel: OnBoardingViewModel by activityViewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel.setFirstTime()
    }

    override fun init() {
        binding.apply {
            viewPager.adapter = OnBoardingAdapter(this@OnBoardingFragment)

            viewPager.registerOnPageChangeCallback(
                object : ViewPager2.OnPageChangeCallback() {
                    override fun onPageSelected(position: Int) {
                        super.onPageSelected(position)

                        binding.buttonBack.isVisible = position != 0

                        if (position == 2) {
                            binding.buttonNext.text = resources.getString(R.string.finish)
                        } else {
                            binding.buttonNext.text = resources.getString(R.string.next)
                        }
                    }
                }
            )

            buttonSkip.setOnClickListener {
                navigateToProducts()
            }

            buttonBack.setOnClickListener {
                val currentItem = binding.viewPager.currentItem
                binding.viewPager.currentItem = currentItem - 1
            }
            buttonNext.setOnClickListener {
                val currentItem = binding.viewPager.currentItem
                if (currentItem == 2) {
                    navigateToProducts()
                } else {
                    binding.viewPager.currentItem = currentItem + 1
                }
            }
        }
    }

    private fun navigateToProducts() {
        val action =
            OnBoardingFragmentDirections.actionOnBoardingFragmentToProductsFragment()
        findNavController().navigate(action)
    }
}
