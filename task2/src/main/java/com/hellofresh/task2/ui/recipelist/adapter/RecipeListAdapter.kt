package com.hellofresh.task2.ui.recipelist.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.hellofresh.task2.databinding.RecipeItemBinding
import com.hellofresh.task2.ui.recipelist.model.RecipeView

class RecipeListAdapter :
    ListAdapter<RecipeView, RecipeListAdapter.ViewHolder>(RecipeDiffCallback) {

    inner class ViewHolder(private val binding: RecipeItemBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(recipeView: RecipeView) {
            binding.recipe = recipeView
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = RecipeItemBinding.inflate(inflater, parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) =
        holder.bind(getItem(position))
}

object RecipeDiffCallback : DiffUtil.ItemCallback<RecipeView>() {
    override fun areItemsTheSame(oldItem: RecipeView, newItem: RecipeView): Boolean {
        return oldItem == newItem
    }

    override fun areContentsTheSame(oldItem: RecipeView, newItem: RecipeView): Boolean {
        return oldItem.id == newItem.id
    }
}