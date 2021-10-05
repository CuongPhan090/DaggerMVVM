package com.example.b32daggermvvm.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.example.b32daggermvvm.R
import com.example.b32daggermvvm.databinding.ActivityMainBinding
import com.example.b32daggermvvm.viewModel.ActivityViewModel

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    lateinit var viewModel: ActivityViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        viewModel = ViewModelProvider(this).get(ActivityViewModel::class.java)
        binding.userCredential = viewModel

        setupObservers()
    }

    private fun setupObservers() {
        viewModel.error.observe(this) {
            Toast.makeText(baseContext, it, Toast.LENGTH_LONG).show()
        }

        viewModel.userInfo.observe(this) {
            Toast.makeText(baseContext, "Login", Toast.LENGTH_LONG).show()
            Log.d(localClassName, it.toString())
        }

        viewModel.success.observe(this) {
            Toast.makeText(baseContext, "Success log in", Toast.LENGTH_LONG).show()
        }
    }
}