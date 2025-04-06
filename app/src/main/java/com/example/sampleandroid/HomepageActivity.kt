package com.example.uconeshop

import android.content.Intent
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.sampleandroid.R
import com.example.sampleandroid.OrderActivity
import com.example.sampleandroid.ShopAllActivity
import com.example.sampleandroid.CartActivity
import com.example.sampleandroid.ProfileActivity


class HomepageActivity : AppCompatActivity() {

    private lateinit var homeIcon: ImageView
    private lateinit var shopIcon: ImageView
    private lateinit var cartIcon: ImageView
    private lateinit var ordersIcon: ImageView
    private lateinit var profileIcon: ImageView
    private lateinit var searchBar: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_homepage)

        // Initialize views
        homeIcon = findViewById(R.id.home_icon)
        shopIcon = findViewById(R.id.shop_icon)
        cartIcon = findViewById(R.id.cart_icon)
        ordersIcon = findViewById(R.id.orders_icon)
        profileIcon = findViewById(R.id.profile_icon)
        searchBar = findViewById(R.id.search_bar)

        // Set click listeners for each icon

        homeIcon.setOnClickListener {
            // Navigate to Homepage or show a Toast (in this case, we assume it's already on the homepage)
            Toast.makeText(this, "Home clicked", Toast.LENGTH_SHORT).show()
            // You could navigate to the homepage activity if needed
            // val intent = Intent(this, HomepageActivity::class.java)
            // startActivity(intent)
        }

        shopIcon.setOnClickListener {
            // Navigate to Shop Activity
            val intent = Intent(this, ShopAllActivity::class.java)
            startActivity(intent)
        }

        cartIcon.setOnClickListener {
            // Navigate to Cart Activity
            val intent = Intent(this, CartActivity::class.java)
            startActivity(intent)
        }

        ordersIcon.setOnClickListener {
            // Navigate to Orders Activity
            val intent = Intent(this, OrderActivity::class.java)
            startActivity(intent)
        }

        profileIcon.setOnClickListener {
            // Navigate to Profile Activity
            val intent = Intent(this, ProfileActivity::class.java)
            startActivity(intent)
        }

        searchBar.setOnClickListener {
            // Handle search bar click (could show a search screen, or a search dialog)
            Toast.makeText(this, "Search clicked", Toast.LENGTH_SHORT).show()
            // Optionally, show a dialog or new activity for searching
        }
    }
}
