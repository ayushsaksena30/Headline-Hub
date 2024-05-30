package com.example.offlinenews

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class newsAdapter(private val newsList: ArrayList<headline>): RecyclerView.Adapter<newsAdapter.headlineViewHolder>(){

    class headlineViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        val imageView: ImageView=itemView.findViewById(R.id.imageView)
        val textView: TextView=itemView.findViewById(R.id.textView)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): headlineViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.each_item, parent, false)
        return headlineViewHolder(view)
    }

    override fun getItemCount(): Int {
        return newsList.size
    }

    override fun onBindViewHolder(holder: headlineViewHolder, position: Int) {
        val news = newsList[position]
        holder.imageView.setImageResource(news.image)
        holder.textView.text=news.name
    }
}