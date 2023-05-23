package com.gttan.gove.presentation.features.sign_in

import androidx.core.widget.doAfterTextChanged
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import com.google.android.material.snackbar.Snackbar
import com.gttan.gove.databinding.FragmentSignInBinding
import com.gttan.gove.presentation.base.BaseFragment
import com.gttan.gove.presentation.features.auth.AuthFragment
import com.gttan.gove.presentation.features.auth.AuthProgressDialog
import com.gttan.gove.presentation.features.auth.AuthState
import kotlinx.coroutines.launch

class SignInFragment : BaseFragment<FragmentSignInBinding>() {

    private val viewModel by activityViewModels<SignInViewModel>()

    override fun init() {
        val loadingDialog = AuthProgressDialog(requireContext())

        viewLifecycleOwner.lifecycleScope.launch {
            viewLifecycleOwner.repeatOnLifecycle(Lifecycle.State.STARTED) {
                viewModel.state.collect { state ->
                    if (state.isLoading) {
                        loadingDialog.show()
                    } else {
                        loadingDialog.hide()
                    }

                    when (state.authState) {
                        AuthState.Success -> {
                            (parentFragment as AuthFragment).navigateToMain()
                        }

                        is AuthState.Error -> {
                            Snackbar.make(binding.root, state.authState.error, Snackbar.LENGTH_LONG)
                                .show()
                        }

                        else -> {}
                    }
                }
            }
        }

        binding.apply {
            editTextSignInEmail.doAfterTextChanged {
                viewModel.setEmail(it.toString())
            }
            editTextSignInPassword.doAfterTextChanged {
                viewModel.setPassword(it.toString())
            }
            buttonSignIn.setOnClickListener {
                viewModel.signIn()
            }
        }
    }

}
