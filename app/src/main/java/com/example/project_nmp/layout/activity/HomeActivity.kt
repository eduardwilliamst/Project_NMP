package com.example.project_nmp.layout.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.project_nmp.Cerbung
import com.example.project_nmp.CerbungAdapter
import com.example.project_nmp.Global
import com.example.project_nmp.R
import com.google.android.material.button.MaterialButton
import com.google.android.material.button.MaterialButtonToggleGroup
import com.google.android.material.floatingactionbutton.FloatingActionButton

class HomeActivity : AppCompatActivity() {

    private var recycler: RecyclerView? = null

    private val adapter = CerbungAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        recycler = findViewById(R.id.recycler_view)

        recycler?.layoutManager = LinearLayoutManager(this)
        recycler?.adapter = this.adapter

        this.adapter.updateData(provideData())

        val fabButton: FloatingActionButton = findViewById(R.id.fab_create)
        fabButton.setOnClickListener {
            val intent = Intent(this, Create1Activity::class.java)
            startActivity(intent)
        }

        val toggleGroup = findViewById<MaterialButtonToggleGroup>(R.id.toggle_group)

        val genres = Global.genre

        for (genre in genres) {

            val button = MaterialButton(this)
            button.id = View.generateViewId()
            button.text = genre.toString()
            button.layoutParams = LinearLayout.LayoutParams(
                ViewGroup.LayoutParams.WRAP_CONTENT,
                ViewGroup.LayoutParams.WRAP_CONTENT
            )

            toggleGroup.addView(button)
        }

        toggleGroup.check(toggleGroup.getChildAt(0).id)
    }

    private fun provideData(): List<Cerbung> {
        val data = mutableListOf<Cerbung>()
        val tipe = intent.getStringExtra("tipe")

        for (cerbung in Global.dataCerbung) {

            data.add(
                Cerbung(
                    cerbung.id, // ID
                    cerbung.title, // Title
                    cerbung.description, // Short Description
                    cerbung.genre_id, // Genre
                    cerbung.imageCover, // Image Cover URL
                    cerbung.author, // Author
                    cerbung.likes, // Like Count
                    cerbung.paragraphs, // Paragraphs Count
                    cerbung.accessControl, // Access Control
                    cerbung.firstparagraphs, // First Paragraph
                )
            )
        }

        return data
    }

}