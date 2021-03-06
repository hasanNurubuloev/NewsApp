package com.geektech.newsapp.ui.detail_news

import android.app.Activity
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import com.bumptech.glide.Glide
import com.geektech.newsapp.R
import com.geektech.newsapp.model.Articles
import kotlinx.android.synthetic.main.activity_detail_news.*
import kotlinx.android.synthetic.main.activity_detail_news.view.*

class DetailNewsActivity : AppCompatActivity() {

    private var articles: Articles? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_news)
        init()
    }

    private fun init() {
      dn_btn_back.setOnClickListener{finish()}
        val intent = intent
        Glide.with(this).load(intent.getStringExtra("urlToImage")).into(detail_image)
        detail_text_title.text = intent.getStringExtra("title")
        detail_text_description.text = intent.getStringExtra("description")
        detail_text_url.text = intent.getStringExtra("url")
        detail_text_author.text = intent.getStringExtra("author")
        detail_text_url.setOnClickListener {
            startActivity(Intent(Intent.ACTION_VIEW, Uri.parse(intent.getStringExtra("url"))))

        }
    }

    companion object {
        public fun instance(activity: Activity?, articles: Articles) {
            activity?.startActivity(
                Intent(activity, DetailNewsActivity::class.java)
                    .putExtra("title", articles.title)
                    .putExtra("description", articles.description)
                    .putExtra("author", articles.author)
                    .putExtra("content", articles.content)
                    .putExtra("publishedAt", articles.publishedAt)
                    .putExtra("url", articles.url)
                    .putExtra("urlToImage", articles.urlToImage)
            )
        }
    }
}