package com.example.sampleandroid

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.*
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.constraintlayout.widget.ConstraintSet
import com.example.uconeshop.HomepageActivity

class ShopAllActivity : Activity() {

    private lateinit var backButton: ImageView
    private lateinit var searchBar: EditText
    private lateinit var categoryAll: Button
    private lateinit var categoryLanyard: Button
    private lateinit var categoryUniform: Button
    private lateinit var homeIcon: ImageView
    private lateinit var shopIcon: ImageView
    private lateinit var cartIcon: ImageView
    private lateinit var ordersIcon: ImageView
    private lateinit var profileIcon: ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_shopall)

        // Initialize views
        backButton = findViewById(R.id.back_button)
        searchBar = findViewById(R.id.search_bar)
        categoryAll = findViewById(R.id.category_all)
        categoryLanyard = findViewById(R.id.category_lanyard)
        categoryUniform = findViewById(R.id.category_uniform)
        homeIcon = findViewById(R.id.home_icon)
        shopIcon = findViewById(R.id.shop_icon)
        cartIcon = findViewById(R.id.cart_icon)
        ordersIcon = findViewById(R.id.orders_icon)
        profileIcon = findViewById(R.id.profile_icon)

        // Back button click listener
        backButton.setOnClickListener {
            onBackPressed() // Navigate to the previous screen
        }

        // Search bar click listener (You can implement search logic here)
        searchBar.setOnClickListener {
            val query = searchBar.text.toString()
            if (query.isNotEmpty()) {
                Toast.makeText(this, "Searching for: $query", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(this, "Search field is empty", Toast.LENGTH_SHORT).show()
            }
        }

        // Category buttons click listeners
        categoryAll.setOnClickListener {
            filterProducts("All")
        }

        categoryLanyard.setOnClickListener {
            filterProducts("Lanyard")
        }

        categoryUniform.setOnClickListener {
            filterProducts("Uniform/Tshirt")
        }

        // Bottom navigation icon click listeners
        homeIcon.setOnClickListener {
            navigateToHome()
        }

        shopIcon.setOnClickListener {
            navigateToShop()
        }

        cartIcon.setOnClickListener {
            navigateToCart()
        }

        ordersIcon.setOnClickListener {
            navigateToOrders()
        }

        profileIcon.setOnClickListener {
            navigateToProfile()
        }
    }

    // Function to filter products by category (dummy implementation)
    private fun filterProducts(category: String) {
        Toast.makeText(this, "Filtering by category: $category", Toast.LENGTH_SHORT).show()
        // Here you would implement the logic to update the product list based on the category selected.
    }

    // Navigation functions for bottom icons
    private fun navigateToHome() {
        val intent = Intent(this, HomepageActivity::class.java)
        startActivity(intent)
    }

    private fun navigateToShop() {
        val intent = Intent(this, ShopAllActivity::class.java)
        startActivity(intent)
    }

    private fun navigateToCart() {
        val intent = Intent(this, CartActivity::class.java)
        startActivity(intent)
    }

    private fun navigateToOrders() {
        val intent = Intent(this, OrderActivity::class.java)
        startActivity(intent)
    }

    private fun navigateToProfile() {
        val intent = Intent(this, ProfileActivity::class.java)
        startActivity(intent)
    }
}
