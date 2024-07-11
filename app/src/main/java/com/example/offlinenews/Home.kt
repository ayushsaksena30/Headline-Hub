package com.example.offlinenews

import android.os.Bundle
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

class Home : Fragment() {

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

        val retrofit = Retrofit.Builder()
            .baseUrl("https://gnews.io/api/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        val gNewsApi = retrofit.create(GNewsApi::class.java)
        val call = gNewsApi.getTopHeadlines(apiKey, "in", language = "en")

        call.enqueue(object : Callback<NewsResponse> {
            override fun onResponse(call: Call<NewsResponse>, response: Response<NewsResponse>) {
                if (response.isSuccessful) {
                    response.body()?.articles?.let {
                        newsAdapter.setNews(it)
                    }
                } else {
                }
            }

            override fun onFailure(call: Call<NewsResponse>, t: Throwable) {
            }
        })
    }
}