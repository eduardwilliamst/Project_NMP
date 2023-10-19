package com.example.project_nmp

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.RecyclerView

class CerbungAdapter: RecyclerView.Adapter<RecyclerViewHolder>() {

    private val differ = AsyncListDiffer(this, RecyclerDiffUtilCallback())

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerViewHolder {
        return RecyclerViewHolder(
            itemView = LayoutInflater.from(parent.context).inflate(
                R.layout.item_view,
                parent,
                false,
            ),
        )
    }

    override fun getItemCount(): Int {
        return differ.currentList.size
    }

    override fun onBindViewHolder(holder: RecyclerViewHolder, position: Int) {
        holder.bindData(differ.currentList[position])
    }

    @SuppressLint("NotifyDataSetChanged")
    fun updateData(data: List<Cerbung>) {
        differ.submitList(data)
    }
}