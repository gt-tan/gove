package com.gttan.gove.presentation

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isVisible
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupWithNavController
import com.gttan.gove.R
import com.gttan.gove.databinding.ActivityMainBinding
import com.gttan.gove.presentation.util.setPrice
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    // 以下 使用Hilt注入变量,Hilt注入的字段是不可以声明成private的
    // @Inject
    // lateinit var testValue: TestValue

    private val viewModel: MainViewModel by viewModels()

    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initData()
        initView()

        binding.buttonCart.setOnClickListener {
            findNavController(R.id.nav_host_fragment).navigate(
                R.id.action_global_cartFragment
            )
        }
    }

    private fun initData() {
        lifecycleScope.launch {
            lifecycle.repeatOnLifecycle(Lifecycle.State.RESUMED) {
                viewModel.cartTotal.collect { cartTotal ->
                    binding.buttonCart setPrice cartTotal
                }
            }
        }
    }

    private fun initView() {
        val navHostFragment =
            supportFragmentManager.findFragmentById(R.id.nav_host_fragment) as NavHostFragment
        val navController = navHostFragment.navController
        binding.apply {
            bottomNavigationView.setupWithNavController(navController)

            lifecycleScope.launch {
                lifecycle.repeatOnLifecycle(Lifecycle.State.RESUMED) {
                    navController.addOnDestinationChangedListener { _, destination, _ ->
                        when (destination.id) {
                            R.id.splashFragment, R.id.onBoardingFragment -> {
                                showAppBars(false)
                            }

                            R.id.authFragment, R.id.productDetailFragment -> {
                                showAppBars(false)

                            }

                            else -> {
                                showAppBars(true)
                            }
                        }
                    }
                }
            }
        }
    }

    private fun showAppBars(visible: Boolean) {
        binding.apply {
            bottomNavigationView.isVisible = visible
            toolbar.isVisible = visible
        }
    }
}
