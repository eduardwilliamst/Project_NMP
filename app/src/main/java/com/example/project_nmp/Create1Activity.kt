package com.example.project_nmp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.widget.AppCompatButton

class Create1Activity : AppCompatActivity() {

    private var buttonNext: AppCompatButton? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_create)

        buttonNext = findViewById(R.id.nextButton)

        buttonNext?.setOnClickListener{
            startActivity(Intent(this, Create2Activity::class.java))
        }
    }
}