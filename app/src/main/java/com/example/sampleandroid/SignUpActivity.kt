package com.example.sampleandroid

import android.app.Activity
import android.os.Bundle
import android.text.InputType
import android.text.TextUtils
import android.view.View
import android.widget.*
import androidx.core.content.ContextCompat

class SignUpActivity : Activity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up)

        val backButton: ImageView = findViewById(R.id.backButton)
        val emailInput: EditText = findViewById(R.id.emailInput)
        val passwordInput: EditText = findViewById(R.id.passwordInput)
        val confirmPasswordInput: EditText = findViewById(R.id.confirmPasswordInput)
        val togglePassword: ImageView = findViewById(R.id.togglePassword)
        val agreeCheckBox: CheckBox = findViewById(R.id.agreeWithTermsCheckBox)
        val signUpButton: Button = findViewById(R.id.signUPButton)

        var isPasswordVisible = false


        togglePassword.setOnClickListener {
            isPasswordVisible = !isPasswordVisible
            if (isPasswordVisible) {
                passwordInput.inputType = InputType.TYPE_CLASS_TEXT or InputType.TYPE_TEXT_VARIATION_VISIBLE_PASSWORD
                togglePassword.setImageResource(R.drawable.ic_eye_open)
            } else {
                passwordInput.inputType = InputType.TYPE_CLASS_TEXT or InputType.TYPE_TEXT_VARIATION_PASSWORD
                togglePassword.setImageResource(R.drawable.ic_eye_closed)
            }
            passwordInput.setSelection(passwordInput.text.length) // Keep cursor at the end
        }

        // Back Button Click Listener
        backButton.setOnClickListener {
            finish()
        }

        // Sign-Up Button Click Listener
        signUpButton.setOnClickListener {
            val email = emailInput.text.toString().trim()
            val password = passwordInput.text.toString().trim()
            val confirmPassword = confirmPasswordInput.text.toString().trim()
            val isTermsChecked = agreeCheckBox.isChecked

            if (TextUtils.isEmpty(email)) {
                emailInput.error = "Email is required"
                return@setOnClickListener
            }

            if (TextUtils.isEmpty(password)) {
                passwordInput.error = "Password is required"
                return@setOnClickListener
            }

            if (password.length < 6) {
                passwordInput.error = "Password must be at least 6 characters"
                return@setOnClickListener
            }

            if (password != confirmPassword) {
                confirmPasswordInput.error = "Passwords do not match"
                return@setOnClickListener
            }

            if (!isTermsChecked) {
                Toast.makeText(this, "You must agree to the terms and conditions", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            // Successful Sign-Up Logic
            Toast.makeText(this, "Sign Up Successful!", Toast.LENGTH_SHORT).show()
        }
    }
}
