package com.example.project_nmp

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.widget.AppCompatButton

class Create3Activity : AppCompatActivity() {

    private var buttonSave: AppCompatButton? = null
    private var buttonPrev: AppCompatButton? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_create3)

        buttonSave = findViewById(R.id.saveButton)
        buttonPrev = findViewById(R.id.prevButton)

        // Mengambil data dari Create1Activity
        val create1SharedPreferences = getSharedPreferences(Create1Activity.PREFS_NAME, Context.MODE_PRIVATE)
        val cerbungTitle = create1SharedPreferences.getString("cerbungTitle", "") ?: ""
        val cerbungDescription = create1SharedPreferences.getString("cerbungDescription", "") ?: ""
        val cerbungImageCover = create1SharedPreferences.getString("cerbungImageCover", "") ?: ""
        val selectedGenre = create1SharedPreferences.getString("selectedGenre", "") ?: ""
        val create2SharedPreferences = getSharedPreferences(Create2Activity.PREFS_NAME, Context.MODE_PRIVATE)
        val accessControl = create2SharedPreferences.getString("accessControl", "") ?: ""
        val firstParagraph = create2SharedPreferences.getString("firstParagraph", "") ?: ""

        // Menampilkan data sesuai dengan ID yang sesuai di XML
        val cerbungTitleTextView = findViewById<TextView>(R.id.title)
        cerbungTitleTextView.text = cerbungTitle

        val cerbungDescriptionTextView = findViewById<TextView>(R.id.shortDescription)
        cerbungDescriptionTextView.text = cerbungDescription

        val cerbungImageCoverTextView = findViewById<TextView>(R.id.imageCover)
        cerbungImageCoverTextView.text = cerbungImageCover

        val selectedGenreTextView = findViewById<TextView>(R.id.genre)
        selectedGenreTextView.text = selectedGenre

//        val accessControlTextView = findViewById<TextView>(R.id.acc)
//        accessControlTextView.text = accessControl

//        val firstParagraphTextView = findViewById<TextView>(R.id.firstParagraph)
//        firstParagraphTextView.text = firstParagraph


        buttonSave?.setOnClickListener{
            startActivity(Intent(this, MainActivity::class.java))
        }
        buttonPrev?.setOnClickListener{
            startActivity(Intent(this, Create2Activity::class.java))
        }
    }
}