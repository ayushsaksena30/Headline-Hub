package com.example.offlinenews

import android.content.ContentValues.TAG
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class Sports : Fragment() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var newsAdapter: NewsAdapter
    private val apiKey = "91f9567193c22221f3990a6777f7037f"

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        recyclerView = view.findViewById(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(context)
        recyclerView.setHasFixedSize(true)

        newsAdapter = NewsAdapter()
        recyclerView.adapter = newsAdapter

        fetchHomeHeadlines()
    }

    private fun fetchHomeHeadlines() {
        Log.d(TAG, "fetchHomeHeadlines: Starting API call")

        val retrofit = Retrofit.Builder()
            .baseUrl("https://gnews.io/api/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        val gNewsApi = retrofit.create(GNewsApi::class.java)
        val call = gNewsApi.getTopHeadlines(apiKey, "in", category = "sports", language = "en")

        call.enqueue(object : Callback<NewsResponse> {
            override fun onResponse(call: Call<NewsResponse>, response: Response<NewsResponse>) {
                if (response.isSuccessful) {
                    response.body()?.articles?.let {
                        newsAdapter.setNews(it)
                        Log.d(TAG, "fetchHomeHeadlines: API call successful")
                    }
                } else {
                    Log.e(TAG, "fetchHomeHeadlines: API call failed with code ${response.code()}")
                }
            }

            override fun onFailure(call: Call<NewsResponse>, t: Throwable) {
                Log.e(TAG, "fetchHomeHeadlines: API call failed", t)
                // Handle failure
            }
        })
    }

}