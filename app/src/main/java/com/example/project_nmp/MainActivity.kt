package com.example.project_nmp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.floatingactionbutton.FloatingActionButton

class MainActivity : AppCompatActivity() {

    private var recycler: RecyclerView? = null

    private val adapter = CerbungAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recycler = findViewById(R.id.recycler_view)

        recycler?.layoutManager = LinearLayoutManager(this)
        recycler?.adapter = this.adapter

        this.adapter.updateData(provideData())

        val fabButton: FloatingActionButton = findViewById(R.id.fab_create)
        fabButton.setOnClickListener {
            val intent = Intent(this, Create1Activity::class.java)
            startActivity(intent)
        }
    }

    private fun provideData(): List<Cerbung> {
        val data = mutableListOf<Cerbung>()
        val tipe = intent.getStringExtra("tipe")

        for (cerbung in Global.dataCerbung) {

            data.add(
                Cerbung(
                    cerbung.id, // ID
                    cerbung.title, // Title
                    cerbung.shortDescription, // Short Description
                    cerbung.genre, // Genre
                    cerbung.imageCover, // Image Cover URL
                    cerbung.by, // Author
                    cerbung.like, // Like Count
                    cerbung.paragraphs, // Paragraphs Count
                    cerbung.accessControl, // Access Control
                    cerbung.firstParagraph // First Paragraph
                )
            )
        }

        return data
    }

}