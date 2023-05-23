package com.gttan.gove.presentation.features.auth

import androidx.navigation.fragment.findNavController
import com.google.android.material.tabs.TabLayoutMediator
import com.gttan.gove.R
import com.gttan.gove.databinding.FragmentAuthBinding
import com.gttan.gove.presentation.adapter.AuthAdapter
import com.gttan.gove.presentation.base.BaseFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class AuthFragment : BaseFragment<FragmentAuthBinding>() {

    override fun init() {
        setUpViewPager()
        setUpTabLayout()
    }

    private fun setUpViewPager() {
        binding.viewPager.apply {
            adapter = AuthAdapter(this@AuthFragment)
            isUserInputEnabled = false
        }
    }

    private fun setUpTabLayout() {
        TabLayoutMediator(binding.tabLayout, binding.viewPager) { tab, position ->
            when (position) {
                0 -> tab.text = resources.getString(R.string.sign_in)
                1 -> tab.text = resources.getString(R.string.sign_up)
            }
        }.attach()
    }

    fun navigateToMain() {
        val action = AuthFragmentDirections.actionAuthFragmentToProductsFragment()
        findNavController().navigate(action)
    }

    fun openSignInTab() {
        val signInTab = binding.tabLayout.getTabAt(0)
        binding.tabLayout.selectTab(signInTab)
    }

}
