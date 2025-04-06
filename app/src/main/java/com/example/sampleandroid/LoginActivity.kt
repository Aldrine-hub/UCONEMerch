package com.example.yourapp

import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.text.method.PasswordTransformationMethod
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import com.example.sampleandroid.R
import com.example.yourapp.ForgotPasswordActivity
import com.example.sampleandroid.SignUpActivity
import com.example.uconeshop.HomepageActivity

class LoginActivity : AppCompatActivity() {

    private lateinit var sharedPreferences: SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        setTheme(R.style.Theme_SampleAndroid)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        // Initialize SharedPreferences
        sharedPreferences = getSharedPreferences("user_prefs", MODE_PRIVATE)

        // Check if the user is already logged in
        val isLoggedIn = sharedPreferences.getBoolean("isLoggedIn", false)
        if (isLoggedIn) {
            startActivity(Intent(this, HomepageActivity::class.java))
            finish()  // Close the LoginActivity
            return
        }

        val emailInput = findViewById<EditText>(R.id.emailInput)
        val passwordInput = findViewById<EditText>(R.id.passwordInput)
        val signInButton = findViewById<Button>(R.id.signInButton)
        val rememberMeCheckbox = findViewById<CheckBox>(R.id.rememberMeCheckbox)
        val forgotPasswordText = findViewById<TextView>(R.id.forgotPasswordText)
        val googleLogin = findViewById<ImageView>(R.id.googleLogin)
        val cardLogin = findViewById<ImageView>(R.id.cardLogin)
        val signUpText = findViewById<TextView>(R.id.signUpText)

        passwordInput.transformationMethod = PasswordTransformationMethod.getInstance()

        signInButton.setOnClickListener {
            val email = emailInput.text.toString().trim()
            val password = passwordInput.text.toString().trim()

            if (email.isEmpty() || password.isEmpty()) {
                Toast.makeText(this, "Please enter email and password", Toast.LENGTH_SHORT).show()
            } else {
                if (email == "student@example.com" && password == "password123") {
                    Toast.makeText(this, "Login Successful", Toast.LENGTH_SHORT).show()

                    // Save the login state in SharedPreferences
                    val editor = sharedPreferences.edit()
                    editor.putBoolean("isLoggedIn", true)
                    editor.apply()

                    // Check if "Remember Me" is checked
                    if (rememberMeCheckbox.isChecked) {
                        // You can save other info like email if needed for auto-login
                        editor.putString("email", email)
                        editor.apply()
                    }

                    // Navigate to HomepageActivity
                    startActivity(Intent(this, HomepageActivity::class.java))
                    finish()  // Close the LoginActivity
                } else {
                    Toast.makeText(this, "Invalid email or password", Toast.LENGTH_SHORT).show()
                }
            }
        }

        rememberMeCheckbox.setOnCheckedChangeListener { _, isChecked ->
            if (isChecked) {
                Toast.makeText(this, "Remember Me enabled", Toast.LENGTH_SHORT).show()
            }
        }

        forgotPasswordText.setOnClickListener {
            startActivity(Intent(this, ForgotPasswordActivity::class.java))
        }

        googleLogin.setOnClickListener {
            Toast.makeText(this, "Google Login Clicked", Toast.LENGTH_SHORT).show()
        }

        cardLogin.setOnClickListener {
            Toast.makeText(this, "Card Login Clicked", Toast.LENGTH_SHORT).show()
        }

        signUpText.setOnClickListener {
            startActivity(Intent(this, SignUpActivity::class.java))
        }
    }
}
