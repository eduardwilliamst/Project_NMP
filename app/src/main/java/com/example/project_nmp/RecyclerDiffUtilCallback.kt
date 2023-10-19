package com.example.project_nmp

import androidx.recyclerview.widget.DiffUtil

class RecyclerDiffUtilCallback : DiffUtil.ItemCallback<Cerbung>() {
    override fun areItemsTheSame(oldItem: Cerbung, newItem: Cerbung): Boolean {
        return oldItem == newItem
    }

    override fun areContentsTheSame(oldItem: Cerbung, newItem: Cerbung): Boolean {
        return oldItem.title == newItem.title &&
                oldItem.shortDescription == newItem.shortDescription &&
                oldItem.genre == newItem.genre &&
                oldItem.imageCover == newItem.imageCover &&
                oldItem.by == newItem.by &&
                oldItem.like == newItem.like &&
                oldItem.paragraphs == newItem.paragraphs
    }

}