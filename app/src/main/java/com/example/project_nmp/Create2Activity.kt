package com.example.project_nmp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.widget.AppCompatButton

class Create2Activity : AppCompatActivity() {

    private var buttonNext: AppCompatButton? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_create2)

        buttonNext = findViewById(R.id.nextButton)

        buttonNext?.setOnClickListener{
            startActivity(Intent(this, Create3Activity::class.java))
        }
    }
}