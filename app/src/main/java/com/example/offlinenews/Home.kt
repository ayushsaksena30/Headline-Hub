package com.example.offlinenews

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class Home : Fragment() {
    private lateinit var recyclerView: RecyclerView
    private lateinit var newsList: ArrayList<headline>
    private lateinit var newsAdapter: newsAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val rootview= inflater.inflate(R.layout.fragment_home, container, false)
        super.onCreate(savedInstanceState)
        recyclerView = rootview.findViewById(R.id.recyclerView)
        recyclerView.setHasFixedSize(true)
        recyclerView.layoutManager= LinearLayoutManager(requireActivity())

        newsList = ArrayList()

        newsList.add(headline(R.drawable.difacto_1, "Robotics startup DiFACTO raises \$4.8 Mn"))
        newsList.add(headline(R.drawable.galaxy, "\"A Galaxy Fit For A Queen\": Nasa Unveils Stunning Image"))
        newsList.add(headline(R.drawable.samsung, "Galaxy AI is coming to Galaxy Watches, and sooner than you might think, for some\n"))
        newsList.add(headline(R.drawable.pixel, "Android AICore update for Gemini Nano rolling out to Pixel 8 \n"))
        newsList.add(headline(R.drawable.rain, "Heavy rain: Monsoon arrives in Kerala; Orange alert in 3 districts ...\n"))
        newsList.add(headline(R.drawable.delhi, "Delhi water crisis: Water Minister Atishi to hold emergency meeting today to address water shortage\n"))
        newsList.add(headline(R.drawable.difacto_1, "Robotics startup DiFACTO raises \$4.8 Mn"))
        newsList.add(headline(R.drawable.difacto_1, "Robotics startup DiFACTO raises \$4.8 Mn"))
        newsList.add(headline(R.drawable.difacto_1, "Robotics startup DiFACTO raises \$4.8 Mn"))
        newsList.add(headline(R.drawable.difacto_1, "Robotics startup DiFACTO raises \$4.8 Mn"))

        newsAdapter= newsAdapter(newsList)
        recyclerView.adapter = newsAdapter

        return rootview
    }
}