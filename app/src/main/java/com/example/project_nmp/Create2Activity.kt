package com.example.project_nmp

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import android.widget.RadioGroup
import androidx.appcompat.widget.AppCompatButton

class Create2Activity : AppCompatActivity() {

    private var buttonNext: AppCompatButton? = null
    private var buttonPrev: AppCompatButton? = null

    companion object {
        public const val PREFS_NAME = "cerbung_prefs"

        fun saveData(
            context: Context,
            accessControl: String,
            firstParagraph: String
        ) {
            val sharedPreferences = context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE)
            val editor = sharedPreferences.edit()
            editor.putString("accessControl", accessControl)
            editor.putString("firstParagraph", firstParagraph)
            editor.apply()
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_create2)

        buttonNext = findViewById(R.id.nextButton)
        buttonPrev = findViewById(R.id.prevButton)

        buttonNext?.setOnClickListener{
            val radioGroup = findViewById<RadioGroup>(R.id.accessControlRadioGroup)
            val selectedRadioButtonId = radioGroup.checkedRadioButtonId
            var accessControl = ""

            if (selectedRadioButtonId == R.id.publicRadioButton) {
                accessControl = "Public"
            } else if (selectedRadioButtonId == R.id.privateRadioButton) {
                accessControl = "Private"
            }

            val firstParagraph = (findViewById<EditText>(R.id.firstParagraph)).text.toString()

            // Menyimpan data menggunakan SharedPreferences
            Create2Activity.saveData(this, accessControl, firstParagraph)

            // Pindah ke Create3Activity
            startActivity(Intent(this, Create3Activity::class.java))
        }


        buttonPrev?.setOnClickListener{
            startActivity(Intent(this, Create1Activity::class.java))
        }
    }
}