package com.example.offlinenews

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface GNewsApi {
    @GET("v4/top-headlines")
    fun getTopHeadlines(
        @Query("apikey") apiKey: String,
        @Query("country") country: String,
        @Query("category") category: String? = null,
        @Query("lang") language: String? = null
    ): Call<NewsResponse>
}

data class NewsResponse(val articles: List<NewsItem>)