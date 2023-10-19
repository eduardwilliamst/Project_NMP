package com.example.project_nmp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView

class DetailActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        val cerbungId = intent.getIntExtra("id", -1)

        val cerbung = Global.dataCerbung.find { it.id == cerbungId }

        val detailImage = findViewById<ImageView>(R.id.detailImage)
        val detailTitle = findViewById<TextView>(R.id.detailTitle)
        val detailParagraphs = findViewById<TextView>(R.id.detailParagraphs)
        val detailLike = findViewById<TextView>(R.id.detailLike)
        val detailFirstParagraph = findViewById<TextView>(R.id.detailFirstParagraph)

        if (cerbung != null) {
            val imgResourceId = resources.getIdentifier(cerbung.imageCover, "drawable", packageName)
            detailImage.setImageResource(imgResourceId)
            detailTitle.text = cerbung.title
            detailParagraphs.text = cerbung.paragraphs.toString()
            detailLike.text = cerbung.like.toString()
            detailFirstParagraph.text = cerbung.firstParagraph
        } else {

            detailTitle.text = "Cerbung Tidak Ditemukan"
        }


    }
}