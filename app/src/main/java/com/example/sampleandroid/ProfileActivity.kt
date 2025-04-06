package com.example.sampleandroid

import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.yourapp.LoginActivity

class ProfileActivity : AppCompatActivity() {

    private lateinit var orderSection: LinearLayout
    private lateinit var notificationSection: LinearLayout
    private lateinit var departmentSection: LinearLayout
    private lateinit var logoutSection: LinearLayout
    private lateinit var editProfileButton: Button // Change to Button, not LinearLayout
    private lateinit var sharedPreferences: SharedPreferences
    private lateinit var profileName: TextView
    private lateinit var profileEmail: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile)

        // Initialize SharedPreferences
        sharedPreferences = getSharedPreferences("user_prefs", MODE_PRIVATE)

        // Initialize views
        orderSection = findViewById(R.id.order_section)
        notificationSection = findViewById(R.id.notification_section)
        departmentSection = findViewById(R.id.department_section)
        logoutSection = findViewById(R.id.logout_section)
        editProfileButton = findViewById(R.id.edit_profile_button) // This is now a Button
        profileName = findViewById(R.id.profile_name)
        profileEmail = findViewById(R.id.profile_email)

        // Retrieve user data from SharedPreferences
        val userName = sharedPreferences.getString("name", "User Name") ?: "User Name"
        val userEmail = sharedPreferences.getString("email", "user@example.com") ?: "user@example.com"

        // Set user data in the profile views
        profileName.text = userName
        profileEmail.text = userEmail

        // Set click listeners
        orderSection.setOnClickListener {
            val intent = Intent(this, OrderActivity::class.java)
            startActivity(intent)
        }

        notificationSection.setOnClickListener {
            val intent = Intent(this, NotificationActivity::class.java)
            startActivity(intent)
        }

        departmentSection.setOnClickListener {
            val intent = Intent(this, DepartmentActivity::class.java)
            startActivity(intent)
        }

        // Handle logout logic
        logoutSection.setOnClickListener {
            val editor = sharedPreferences.edit()
            editor.putBoolean("isLoggedIn", false)
            editor.apply()

            Toast.makeText(this, "Logging out...", Toast.LENGTH_SHORT).show()

            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
            finish()
        }

        // Edit Profile Button Click
        editProfileButton.setOnClickListener {
            val intent = Intent(this, EditProfileActivity::class.java)
            // Pass the user's data to the EditProfileActivity
            intent.putExtra("name", userName)
            intent.putExtra("email", userEmail)
            intent.putExtra("phone", sharedPreferences.getString("phone", ""))
            startActivity(intent)
        }

        // Back button logic
        val backButton = findViewById<ImageView>(R.id.back_button)
        backButton.setOnClickListener {
            onBackPressed()
        }
    }
}
