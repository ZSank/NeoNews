package com.example.topnewsapp.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.topnewsapp.data.Article
import com.example.topnewsapp.databinding.ItemListBinding

class NewsListAdapter : ListAdapter<Article, NewsListAdapter.ViewHolder>(DiffCallback) {
	class ViewHolder(private val binding: ItemListBinding) : RecyclerView.ViewHolder(binding.root) {
		fun bind(item: Article) {
			binding.article = item
			binding.executePendingBindings()
		}
	}

	override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
		val binding = ItemListBinding.inflate(LayoutInflater.from(parent.context), parent, false)
		return ViewHolder(binding)
	}

	override fun onBindViewHolder(holder: ViewHolder, position: Int) {
		val item = getItem(position)
		holder.bind(item)
	}

	companion object DiffCallback : DiffUtil.ItemCallback<Article>() {
		override fun areItemsTheSame(oldItem: Article, newItem: Article): Boolean {
			return oldItem.title == newItem.title
		}

		override fun areContentsTheSame(oldItem: Article, newItem: Article): Boolean {
			return oldItem == newItem
		}

	}

}
