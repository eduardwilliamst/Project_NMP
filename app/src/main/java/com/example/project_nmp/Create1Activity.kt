package com.example.project_nmp

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.EditText
import android.widget.Spinner
import androidx.appcompat.widget.AppCompatButton

class Create1Activity : AppCompatActivity() {

    private var buttonNext: AppCompatButton? = null
    private lateinit var cerbungGenreSpinner: Spinner

    companion object {
        public const val PREFS_NAME = "MyPrefs"
        fun saveData(context: Context, cerbungTitle: String, cerbungDescription: String, cerbungImageCover: String, selectedGenre: String) {
            val sharedPreferences = context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE)
            val editor = sharedPreferences.edit()
            editor.putString("cerbungTitle", cerbungTitle)
            editor.putString("cerbungDescription", cerbungDescription)
            editor.putString("cerbungImageCover", cerbungImageCover)
            editor.putString("selectedGenre", selectedGenre)
            editor.apply()
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_create)

        buttonNext = findViewById(R.id.nextButton)

        cerbungGenreSpinner = findViewById(R.id.cerbungGenreSpinner)

        val adapter = ArrayAdapter(this, R.layout.simple_list_item_1, Global.genre)
        adapter.setDropDownViewResource(R.layout.simple_spinner_dropdown_item)

        cerbungGenreSpinner.adapter = adapter

        buttonNext?.setOnClickListener{
            // Mengambil data dari input pengguna
            val cerbungTitle = (findViewById<EditText>(R.id.cerbungTitle)).text.toString()
            val cerbungDescription = (findViewById<EditText>(R.id.cerbungDescription)).text.toString()
            val cerbungImageCover = (findViewById<EditText>(R.id.cerbungImageCover)).text.toString()
            val selectedGenre = cerbungGenreSpinner.selectedItem.toString()

            // Menyimpan data menggunakan SharedPreferences
            saveData(this, cerbungTitle, cerbungDescription, cerbungImageCover, selectedGenre)

            // Pindah ke Create2Activity
            startActivity(Intent(this, Create2Activity::class.java))
        }

    }
}