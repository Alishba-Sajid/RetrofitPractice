package com.example.retrofitpractice

import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import com.example.retrofitpractice.presentation.UserViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private val viewModel: UserViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.STARTED) {

                launch {
                    viewModel.users.collect { users ->
                        Log.d("RetrofitPractice", "Users: $users")
                    }
                }

                launch {
                    viewModel.error.collect { error ->
                        if (error != null) {
                            Log.e("RetrofitPractice", "Error: $error")
                        }
                    }
                }

                launch {
                    viewModel.isLoading.collect { isLoading ->
                        Log.d("RetrofitPractice", "Loading: $isLoading")
                    }
                }
            }
        }

        if (savedInstanceState == null) {
            viewModel.fetchUsers()
        }
    }
}