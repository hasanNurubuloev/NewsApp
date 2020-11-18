package com.geektech.newsapp.ui.main

import com.geektech.newsapp.model.Articles
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.geektech.newsapp.R
import kotlinx.android.synthetic.main.item_main_holder.view.*

class MainAdapter(
    var listener : OnClickHolder
): RecyclerView.Adapter<MainViewHolder>() {
    private var list = mutableListOf<Articles>()
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainViewHolder {
        return MainViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.item_main_holder, parent, false)
        )
    }


    override fun onBindViewHolder(holder: MainViewHolder, position: Int) {
        holder.bind(list[position], listener)
    }

    override fun getItemCount(): Int {
        return list.size
    }
    fun update(elements: MutableList<Articles>) {
        list.addAll(elements)
        notifyDataSetChanged()
    }

}
class MainViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){


    fun bind (articles: Articles, inter: OnClickHolder){

    Glide.with(itemView.context).load(articles.urlToImage).into(itemView.mh_image)
        Log.d("ololo", "bind: " + articles.description)
        itemView.mh_text_title.text=articles.title
        itemView.mh_text_desc.text= articles.description
        itemView.setOnClickListener { inter.onClickHolder(articles, adapterPosition) }
    }
}
interface OnClickHolder{
    fun onClickHolder(news: Articles, position: Int)
}