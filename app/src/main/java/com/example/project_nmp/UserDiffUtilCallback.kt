package com.example.project_nmp

import androidx.recyclerview.widget.DiffUtil

class UserDiffUtilCallback: DiffUtil.ItemCallback<User>() {
    override fun areItemsTheSame(oldItem: User, newItem: User): Boolean {
        return oldItem == newItem
    }

    override fun areContentsTheSame(oldItem: User, newItem: User): Boolean {
        return oldItem.username == newItem.username
    }

}