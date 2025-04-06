package com.example.sampleandroid

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.sampleandroid.R

class EditProfileActivity : AppCompatActivity() {

    private lateinit var nameInput: EditText
    private lateinit var emailInput: EditText
    private lateinit var passwordInput: EditText
    private lateinit var phoneInput: EditText
    private lateinit var saveButton: Button
    private lateinit var backButton: ImageView
    private lateinit var changeAvatarButton: Button
    private lateinit var removeAvatarButton: Button
    private lateinit var imageView: ImageView
    private lateinit var profileLabel: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_editprofile)

        // Initialize views
        nameInput = findViewById(R.id.name_input)
        emailInput = findViewById(R.id.email_input)
        passwordInput = findViewById(R.id.password_input)
        phoneInput = findViewById(R.id.phone_input)
        saveButton = findViewById(R.id.save_button)
        backButton = findViewById(R.id.back_button)
        changeAvatarButton = findViewById(R.id.change_avatar_button)
        removeAvatarButton = findViewById(R.id.remove_avatar_button)
        imageView = findViewById(R.id.imageView)
        profileLabel = findViewById(R.id.uconeshop_label)

        // Retrieve the user data passed from ProfileActivity
        val name = intent.getStringExtra("name")
        val email = intent.getStringExtra("email")
        val phone = intent.getStringExtra("phone")

        // Populate the EditText fields with existing data
        nameInput.setText(name)
        emailInput.setText(email)
        phoneInput.setText(phone)

        // Back Button functionality
        backButton.setOnClickListener {
            finish() // Go back to the previous activity
        }

        // Change Avatar Button functionality
        changeAvatarButton.setOnClickListener {
            // Logic to open image picker (camera/gallery)
            Toast.makeText(this, "Change Avatar clicked", Toast.LENGTH_SHORT).show()
        }

        // Remove Avatar Button functionality
        removeAvatarButton.setOnClickListener {
            imageView.setImageResource(R.drawable.default_avatar) // Set default avatar
        }

        // Save button click logic
        saveButton.setOnClickListener {
            val updatedName = nameInput.text.toString()
            val updatedEmail = emailInput.text.toString()
            val updatedPhone = phoneInput.text.toString()

            if (updatedName.isEmpty() || updatedEmail.isEmpty() || updatedPhone.isEmpty()) {
                Toast.makeText(this, "Please fill out all fields", Toast.LENGTH_SHORT).show()
            } else {
                // Save updated profile data (e.g., update SharedPreferences)
                val sharedPreferences = getSharedPreferences("user_prefs", MODE_PRIVATE)
                val editor = sharedPreferences.edit()
                editor.putString("name", updatedName)
                editor.putString("email", updatedEmail)
                editor.putString("phone", updatedPhone)
                editor.apply()

                // Show success message
                Toast.makeText(this, "Profile updated!", Toast.LENGTH_SHORT).show()

                // Optionally, navigate back to ProfileActivity after saving the data
                finish()
            }
        }
    }
}
