package com.example.offlinenews

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

class NewsAdapter : RecyclerView.Adapter<NewsAdapter.NewsViewHolder>() {

    private var newsList: List<NewsItem> = listOf()

    class NewsViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val imageView: ImageView = itemView.findViewById(R.id.imageView)
        val titleView: TextView = itemView.findViewById(R.id.tv_title)
        val descriptionView: TextView = itemView.findViewById(R.id.tv_description)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewsViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.each_item, parent, false)
        return NewsViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: NewsViewHolder, position: Int) {
        val currentItem = newsList[position]
        holder.titleView.text = currentItem.title
        holder.descriptionView.text = currentItem.description

        if (currentItem.image != null) {
            Glide.with(holder.itemView.context).load(currentItem.image).into(holder.imageView)
        } else {
            holder.imageView.setImageResource(R.drawable.rain)
        }
    }

    override fun getItemCount() = newsList.size

    fun setNews(news: List<NewsItem>) {
        this.newsList = news
        notifyDataSetChanged()
    }
}