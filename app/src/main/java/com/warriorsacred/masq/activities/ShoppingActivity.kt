package com.warriorsacred.masq.activities

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.setupWithNavController
import com.warriorsacred.masq.R
import com.warriorsacred.masq.databinding.ActivityShoppingBinding

class ShoppingActivity : AppCompatActivity() {

    val binding by lazy {
        ActivityShoppingBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        val navController = findNavController(R.id.shoppingHostFragment)
        binding.bottomNavigation.setupWithNavController(navController)
    }
}