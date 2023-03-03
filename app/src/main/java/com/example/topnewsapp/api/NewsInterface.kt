package com.example.topnewsapp.api

import com.example.topnewsapp.data.News
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query

const val BASE_URL = "https://newsapi.org/"
const val API_KEY = "964af6b2d59643cd8cb78c6763551fed"
private val moshi = Moshi.Builder().add(KotlinJsonAdapterFactory()).build()
private val retrofit = Retrofit.Builder().addConverterFactory(MoshiConverterFactory.create(moshi))
	.baseUrl(BASE_URL).build()

interface NewsInterface {
	@GET("v2/top-headlines?apikey=$API_KEY")
	suspend fun headlines(
		@Query("country") country: String = "in",
		@Query("page") page: Int = 1
	): News
}

object NewsApi {
	val retrofitService: NewsInterface by lazy { retrofit.create(NewsInterface::class.java) }
}









