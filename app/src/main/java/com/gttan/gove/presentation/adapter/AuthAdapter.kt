package com.gttan.gove.presentation.adapter

import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.gttan.gove.presentation.features.sign_in.SignInFragment
import com.gttan.gove.presentation.features.sign_up.SignUpFragment

private val authFragments = listOf(
    SignInFragment(),
    SignUpFragment()
)

class AuthAdapter(fragment: Fragment) : FragmentStateAdapter(fragment) {
    override fun getItemCount(): Int = authFragments.size
    override fun createFragment(position: Int): Fragment = authFragments[position]
}
