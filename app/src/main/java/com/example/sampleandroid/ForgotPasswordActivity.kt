package com.example.yourapp

import android.content.Intent
import android.os.Bundle
import android.util.Patterns
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.sampleandroid.R

class ForgotPasswordActivity : AppCompatActivity() {

    private lateinit var emailInput: EditText
    private lateinit var sendCodeButton: Button
    private lateinit var backButton: ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_forgot_password)


        emailInput = findViewById(R.id.emailInput)
        sendCodeButton = findViewById(R.id.sendCodeButton)
        backButton = findViewById(R.id.backButton)


        backButton.setOnClickListener {
            finish()
        }


        sendCodeButton.setOnClickListener {
            val email = emailInput.text.toString().trim()

            if (!isValidEmail(email)) {
                Toast.makeText(this, "Please enter a valid email address", Toast.LENGTH_SHORT).show()
            } else {
                sendCodeButton.isEnabled = false
                sendVerificationCode(email)
            }
        }
    }

    private fun sendVerificationCode(email: String) {
        Toast.makeText(this, "Verification code sent to $email", Toast.LENGTH_LONG).show()


        val intent = Intent(this, VerifyCodeActivity::class.java)
        intent.putExtra("email", email)
        startActivity(intent)


        sendCodeButton.isEnabled = true
    }


    private fun isValidEmail(email: String): Boolean {
        return Patterns.EMAIL_ADDRESS.matcher(email).matches()
    }
}
