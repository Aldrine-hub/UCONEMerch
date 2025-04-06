package com.example.yourapp

import android.content.Intent
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.sampleandroid.R
import com.example.yourapp.ForgotPasswordActivity
import com.example.sampleandroid.ResetPasswordActivity

class VerifyCodeActivity : AppCompatActivity() {

    private lateinit var otp1: EditText
    private lateinit var otp2: EditText
    private lateinit var otp3: EditText
    private lateinit var otp4: EditText
    private lateinit var verifyButton: Button
    private lateinit var resendCodeText: TextView
    private lateinit var backButton: ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.verify_code)

        // Initialize views
        otp1 = findViewById(R.id.otp1)
        otp2 = findViewById(R.id.otp2)
        otp3 = findViewById(R.id.otp3)
        otp4 = findViewById(R.id.otp4)
        verifyButton = findViewById(R.id.verifyButton)
        resendCodeText = findViewById(R.id.resendCodeText)
        backButton = findViewById(R.id.backButton)

        // Back button click
        backButton.setOnClickListener {
            finish()
        }

        // Handle OTP input auto-move
        setupOtpInputs()

        // Verify button click
        verifyButton.setOnClickListener {
            val otpCode = otp1.text.toString() + otp2.text.toString() +
                    otp3.text.toString() + otp4.text.toString()

            if (otpCode.length < 4) {
                Toast.makeText(this, "Please enter all 4 digits", Toast.LENGTH_SHORT).show()
            } else {
                verifyOtp(otpCode)
            }
        }

        // Resend code click
        resendCodeText.setOnClickListener {
            Toast.makeText(this, "Resending code...", Toast.LENGTH_SHORT).show()
            resendVerificationCode()
        }
    }

    // Function to auto-move to the next OTP input
    private fun setupOtpInputs() {
        val otpFields = arrayOf(otp1, otp2, otp3, otp4)

        for (i in otpFields.indices) {
            otpFields[i].addTextChangedListener(object : TextWatcher {
                override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}
                override fun afterTextChanged(s: Editable?) {}

                override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                    if (s?.length == 1 && i < otpFields.size - 1) {
                        otpFields[i + 1].requestFocus()
                    } else if (s?.isEmpty() == true && i > 0) {
                        otpFields[i - 1].requestFocus()
                    }
                }
            })
        }
    }

    // Function to verify OTP
    private fun verifyOtp(otp: String) {

        if (otp == "1234") {
            Toast.makeText(this, "OTP Verified!", Toast.LENGTH_LONG).show()
            startActivity(Intent(this, ResetPasswordActivity::class.java)) // Navigate to next screen
            finish()
        } else {
            Toast.makeText(this, "Invalid OTP! Please try again.", Toast.LENGTH_SHORT).show()
        }
    }


    private fun resendVerificationCode() {
        Toast.makeText(this, "New verification code sent!", Toast.LENGTH_LONG).show()
    }
}
