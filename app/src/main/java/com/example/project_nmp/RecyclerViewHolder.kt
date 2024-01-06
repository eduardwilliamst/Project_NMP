package com.example.project_nmp

import android.content.Intent
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.project_nmp.layout.activity.DetailActivity
import com.squareup.picasso.Picasso

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


        // Set data to the views
        Picasso.get().load(data.imageCover).into(coverImage)

        //coverImage.setImageResource(imgResourceId)
        titleText.text = data.title
        byText.text = "by ${data.author}"
        paragraphsText.text = data.paragraphs.toString()
        likeText.text = data.likes.toString()
        descriptionText.text = data.description

        // Handle click event for read button (gunakan cerbung.id untuk navigasi)
        readButton.setOnClickListener {
            val intent = Intent(itemView.context, DetailActivity::class.java)
            intent.action = Intent.ACTION_SEND
            intent.putExtra("id", data.id)
            itemView.context.startActivity(intent)
        }

    }
}
