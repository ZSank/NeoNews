package com.example.topnewsapp.adapter

import android.util.Log
import android.widget.ImageView
import android.widget.TextView
import androidx.core.net.toUri
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.example.topnewsapp.R
import com.example.topnewsapp.data.Article


val tempData = listOf<Article>(
	Article("tit", "asdf"),
	Article("ttsfasfd", "kldjflaf")
)

@BindingAdapter("listData")
fun bindRecyclerView(recyclerView: RecyclerView, data: List<Article>?) {

	val adapter = recyclerView.adapter as NewsListAdapter
	adapter.submitList(data)
}

@BindingAdapter("imageUrl")
fun bindImage(imgView: ImageView, imgUrl: String?) {
	imgUrl?.let {
		val imgUri = imgUrl.toUri().buildUpon().scheme("https").build()
		imgView.load(imgUri) {
			placeholder(R.drawable.loading_animation)
			error(R.drawable.ic_broken_image)
		}
	}
}

@BindingAdapter("Logging")
fun logging(view: TextView, data: String) {
	Log.d("customLog", data)
}
