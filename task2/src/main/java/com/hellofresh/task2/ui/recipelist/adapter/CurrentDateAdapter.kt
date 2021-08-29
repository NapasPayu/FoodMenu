package com.hellofresh.task2.ui.recipelist.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.hellofresh.task2.databinding.CurrentDateItemBinding

class CurrentDateAdapter :
    ListAdapter<String, CurrentDateAdapter.ViewHolder>(CurrentDateDiffCallback) {

    inner class ViewHolder(private val binding: CurrentDateItemBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(date: String) {
            binding.date = date
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = CurrentDateItemBinding.inflate(inflater, parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) =
        holder.bind(getItem(position))
}

object CurrentDateDiffCallback : DiffUtil.ItemCallback<String>() {
    override fun areItemsTheSame(oldItem: String, newItem: String): Boolean {
        return oldItem == newItem
    }

    override fun areContentsTheSame(oldItem: String, newItem: String): Boolean {
        return oldItem == newItem
    }
}