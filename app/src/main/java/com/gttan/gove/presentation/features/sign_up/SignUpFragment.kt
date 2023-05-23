package com.gttan.gove.presentation.features.sign_up

import androidx.core.widget.doAfterTextChanged
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import com.google.android.material.snackbar.Snackbar
import com.gttan.gove.R
import com.gttan.gove.databinding.FragmentSignUpBinding
import com.gttan.gove.presentation.base.BaseFragment
import com.gttan.gove.presentation.features.auth.AuthFragment
import com.gttan.gove.presentation.features.auth.AuthProgressDialog
import com.gttan.gove.presentation.features.auth.AuthState
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class SignUpFragment : BaseFragment<FragmentSignUpBinding>() {


    private val viewModel by activityViewModels<SignUpViewModel>()

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

                    when (val uiState = state.authState) {
                        AuthState.Success -> {
                            lifecycleScope.launch {
                                Snackbar.make(
                                    binding.root,
                                    getString(R.string.sign_up_successful),
                                    Snackbar.LENGTH_SHORT
                                ).show()
                                viewModel.clear()
                                (parentFragment as AuthFragment).openSignInTab()
                            }
                        }

                        is AuthState.Error -> {
                            Snackbar.make(binding.root, uiState.error, Snackbar.LENGTH_LONG).show()
                        }

                        else -> {}
                    }
                }
            }
        }

        binding.apply {
            editTextFullName.doAfterTextChanged {
                viewModel.setFullName(it.toString())
            }
            editTextUsername.doAfterTextChanged {
                viewModel.setUsername(it.toString())
            }
            editTextEmail.doAfterTextChanged {
                viewModel.setEmail(it.toString())
            }
            editTextPassword.doAfterTextChanged {
                viewModel.setPassword(it.toString())
            }
            editTextPasswordAgain.doAfterTextChanged {
                viewModel.setPasswordAgain(it.toString())
            }
            buttonSignUp.setOnClickListener {
                viewModel.signUp()
            }
        }
    }
}
