package com.example.project_nmp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.widget.AppCompatButton

class Create3Activity : AppCompatActivity() {

    private var buttonSave: AppCompatButton? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_create3)

        buttonSave = findViewById(R.id.saveButton)

        buttonSave?.setOnClickListener{
            startActivity(Intent(this, MainActivity::class.java))
        }
    }
}