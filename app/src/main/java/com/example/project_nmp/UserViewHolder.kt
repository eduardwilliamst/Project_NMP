package com.example.project_nmp

import android.content.Intent
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.project_nmp.layout.activity.DetailUserActivity
import com.squareup.picasso.Picasso

class UserViewHolder(
    private val itemView: View
) : RecyclerView.ViewHolder(itemView) {

    private val imageViewAvatar: ImageView = itemView.findViewById(R.id.imageViewAvatar)
    private val textViewUsername: TextView = itemView.findViewById(R.id.textViewUsername)
    private val textViewDateJoined: TextView = itemView.findViewById(R.id.textViewDateJoined)
    private val textViewTotalLikes: TextView = itemView.findViewById(R.id.textViewTotalLikes)

    fun bindData(user: User) {
        // Set data to views
        textViewUsername.text = user.username
        textViewDateJoined.text = user.dateJoined.toString() // Convert Date to String if needed
        textViewTotalLikes.text = user.totalLikes.toString()

        // Load image using Picasso library
        Picasso.get().load(user.urlProfilePicture).placeholder(R.drawable.profile).into(imageViewAvatar)

        itemView.setOnClickListener {
             val intent = Intent(itemView.context, DetailUserActivity::class.java)
             intent.putExtra("username", user.username)
             itemView.context.startActivity(intent)
        }
    }
}
