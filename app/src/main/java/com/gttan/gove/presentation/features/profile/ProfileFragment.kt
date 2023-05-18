package com.gttan.gove.presentation.features.profile

import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.navigation.fragment.findNavController
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import com.gttan.gove.R
import com.gttan.gove.databinding.FragmentProfileBinding
import com.gttan.gove.presentation.base.BaseFragment
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class ProfileFragment : BaseFragment<FragmentProfileBinding>() {

    private val viewModel: ProfileViewModel by activityViewModels()

    override fun init() {
        viewLifecycleOwner.lifecycleScope.launch {
            viewLifecycleOwner.repeatOnLifecycle(Lifecycle.State.STARTED) {
                viewModel.state.collect { state ->
                    binding.textFullName.text = state.fullName
                    binding.textUsername.text = state.username
                }
            }
        }

        binding.buttonLogOut.setOnClickListener {
            showSignOutDialog()
        }
    }

    private fun showSignOutDialog() {
        MaterialAlertDialogBuilder(requireContext())
            .setTitle(resources.getString(R.string.dialog_title_sign_out))
            .setMessage(resources.getString(R.string.dialog_message_sign_out))
            .setPositiveButton(resources.getString(R.string.confirm)) { _, _ ->
                viewModel.signOut().also {
                    val action =
                        ProfileFragmentDirections.actionProfileFragmentToAuthFragment()
                    findNavController().navigate(action)
                }
            }
            .setNeutralButton(resources.getString(R.string.cancel)) { dialog, _ ->
                dialog.cancel()
            }
            .show()
    }
}
