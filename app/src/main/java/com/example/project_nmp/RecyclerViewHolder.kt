package com.example.project_nmp

import android.content.Intent
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.floatingactionbutton.FloatingActionButton

class RecyclerViewHolder(
    private val itemView: View
) : RecyclerView.ViewHolder(itemView) {

    fun bindData(data: Cerbung) {
        val coverImage = itemView.findViewById<ImageView>(R.id.coverImage)
        val imgResourceId = itemView.context.resources.getIdentifier(data.imageCover, "drawable", itemView.context.packageName)

        val titleText = itemView.findViewById<TextView>(R.id.titleText)
        val byText = itemView.findViewById<TextView>(R.id.byText)
        val paragraphsText = itemView.findViewById<TextView>(R.id.paragraphsText)
        val likeText = itemView.findViewById<TextView>(R.id.likeText)
        val descriptionText = itemView.findViewById<TextView>(R.id.descriptionText)
        val readButton = itemView.findViewById<Button>(R.id.readButton)
        val createButton = itemView.findViewById<FloatingActionButton>(R.id.fab_create)

        // Set data to the views
        coverImage.setImageResource(imgResourceId)
        titleText.text = data.title
        byText.text = "by ${data.by}"
        paragraphsText.text = data.paragraphs.toString()
        likeText.text = data.like.toString()
        descriptionText.text = data.shortDescription

        // Handle click event for read button (gunakan cerbung.id untuk navigasi)
        readButton.setOnClickListener {
            val intent = Intent(itemView.context, DetailActivity::class.java)
            intent.action = Intent.ACTION_SEND
            intent.putExtra("id", data.id)
            itemView.context.startActivity(intent)
        }

    }
}
