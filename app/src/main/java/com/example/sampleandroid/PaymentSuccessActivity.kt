package com.example.sampleandroid

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.example.uconeshop.HomepageActivity

class PaymentSuccessActivity : AppCompatActivity() {

    private lateinit var backToHomeButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.payment_successful)

        // Initialize the back to home button
        backToHomeButton = findViewById(R.id.back_to_home_button)

        // Set the onClick listener for the button
        backToHomeButton.setOnClickListener {
            // Navigate to HomepageActivity when the button is clicked
            navigateToHomepage()
        }
    }

    // Method to navigate to the HomepageActivity
    private fun navigateToHomepage() {
        val intent = Intent(this, HomepageActivity::class.java) // Update to the correct package
        startActivity(intent)
        finish() // Optionally, finish the current activity to prevent going back
    }
}
