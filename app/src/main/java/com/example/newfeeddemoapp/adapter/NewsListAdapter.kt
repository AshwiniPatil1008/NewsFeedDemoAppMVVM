package com.example.newfeeddemoapp.adapter


import android.app.Activity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.FragmentActivity
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.example.newfeeddemoapp.R
import com.example.newfeeddemoapp.Models.News
import kotlinx.android.synthetic.main.news_item_list.view.*

class NewsListAdapter(
    val listOfNews: List<News>,
    activity: FragmentActivity?
) : RecyclerView.Adapter<NewsListAdapter.NewsListViewHolder>() {

    lateinit var mActivity: Activity

    init {
        this.mActivity = activity!!
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): NewsListAdapter.NewsListViewHolder {
        return NewsListAdapter.NewsListViewHolder(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.news_item_list, parent, false)
        )
    }

    override fun getItemCount() = listOfNews.size


    override fun onBindViewHolder(
        holder: NewsListAdapter.NewsListViewHolder,
        position: Int
    ) {
        holder.bindItems(listOfNews[position])

        val newsDetails = listOfNews[position]

        Glide.with(mActivity).load(newsDetails.newsImage)
            .apply(RequestOptions.fitCenterTransform()).into(holder.view.ivNewsImg)

        holder.view.tv_news_title.text = newsDetails.newsTitle!!
        holder.view.tv_news_desc.text = newsDetails.newsDescription



    }


    class NewsListViewHolder(val view: View) : RecyclerView.ViewHolder(view) {
        fun bindItems(news: News) {
            val textViewTitle = view.findViewById(R.id.tv_news_title) as TextView
            val textViewDesc  = view.findViewById(R.id.tv_news_desc) as TextView
            val image=view.findViewById(R.id.ivNewsImg) as ImageView
            textViewTitle.text = news.newsTitle
            textViewDesc.text = news.newsDescription
//            image.setBackgroundResource(news.newsImage)

        }
    }




}