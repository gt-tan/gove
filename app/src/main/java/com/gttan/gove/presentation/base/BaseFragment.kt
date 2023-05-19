package com.gttan.gove.presentation.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.viewbinding.ViewBinding

abstract class BaseFragment<VB : ViewBinding> : Fragment(), IBinding<VB> {

    private var _binding: VB? = null

    /**
     * You can't call [binding] after [onDestroyView]
     */
    override val binding: VB
        get() = checkNotNull(_binding) {
            "Binding has been destroyed"
        }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = inflateBinding(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        init()
    }

    abstract fun init()

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}
