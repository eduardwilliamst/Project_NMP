package com.example.project_nmp

import androidx.recyclerview.widget.DiffUtil

class RecyclerDiffUtilCallback : DiffUtil.ItemCallback<Cerbung>() {
    override fun areItemsTheSame(oldItem: Cerbung, newItem: Cerbung): Boolean {
        return oldItem == newItem
    }

    override fun areContentsTheSame(oldItem: Cerbung, newItem: Cerbung): Boolean {
        return oldItem.title == newItem.title &&
                oldItem.description == newItem.description &&
                oldItem.genre_id == newItem.genre_id &&
                oldItem.imageCover == newItem.imageCover &&
                oldItem.author == newItem.author &&
                oldItem.likes == newItem.likes &&
                oldItem.paragraphs == newItem.paragraphs
    }

}