package com.example.topnewsapp.fragment

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.topnewsapp.api.NewsApi
import com.example.topnewsapp.data.News
import kotlinx.coroutines.launch

class Frag1ViewModel : ViewModel() {
	private val _news = MutableLiveData<News>()
	val news: LiveData<News> = _news

	init {
		getNews()
	}

	//	val tempData: List<Article> = listOf(
//		Article("Title1"),
//		Article("Title2"),
//		Article("Title3")
//	)
	private fun getNews() {
		viewModelScope.launch {
			try {
				_news.value = NewsApi.retrofitService.headlines()
				Log.d("newsData",_news.value.toString())
			} catch (e: Exception) {
				_news.value = News(articles = listOf())
				Log.d("newsData",e.toString())
			}
			Log.d("newsData","calling done")
		}
	}
}