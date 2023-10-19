package com.example.project_nmp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.widget.AppCompatButton
import androidx.appcompat.widget.AppCompatEditText
import androidx.appcompat.widget.AppCompatTextView

class SignInActivity : AppCompatActivity() {

    private var btnSignUp: AppCompatButton? = null
    private var btnSignIn: AppCompatButton? = null
    private var user: AppCompatEditText? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_in)

        btnSignUp = findViewById(R.id.button_signup)
        btnSignIn = findViewById(R.id.button_login)

        user = findViewById(R.id.editTextEmail)

        btnSignIn?.setOnClickListener {
            val text: String = user?.text.toString()

            Toast.makeText(this, "Selamat Datang $text", Toast.LENGTH_SHORT).show()
            startActivity(Intent(this, MainActivity::class.java))
        }
        btnSignUp?.setOnClickListener{
            startActivity(Intent(this, SignUpActivity::class.java))
        }
    }
}