package com.example.project_nmp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.widget.AppCompatButton

class SignUpActivity : AppCompatActivity() {

    private var btnSubmit: AppCompatButton? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up)

        btnSubmit = findViewById(R.id.btn_submit)

        btnSubmit?.setOnClickListener {
            Toast.makeText(this, "Berhasil Menyimpan", Toast.LENGTH_SHORT).show()
            startActivity(Intent(this, SignInActivity::class.java))
        }
    }
}