package com.example.project_nmp

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.RecyclerView

class UserAdapter: RecyclerView.Adapter<UserViewHolder>() {

    private val differ = AsyncListDiffer(this, UserDiffUtilCallback())

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserViewHolder {
        return UserViewHolder(
            itemView = LayoutInflater.from(parent.context).inflate(
                R.layout.user_item,
                parent,
                false,
            ),
        )
    }

    override fun getItemCount(): Int {
        return differ.currentList.size
    }

    override fun onBindViewHolder(holder: UserViewHolder, position: Int) {
        holder.bindData(differ.currentList[position])
    }

    @SuppressLint("NotifyDataSetChanged")
    fun updateData(data: List<User>) {
        differ.submitList(data)
    }
}