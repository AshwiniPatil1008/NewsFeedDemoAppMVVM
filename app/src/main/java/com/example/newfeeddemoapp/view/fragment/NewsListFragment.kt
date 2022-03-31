package com.example.newfeeddemoapp.view.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.newfeeddemoapp.R
import com.example.newfeeddemoapp.adapter.NewsListAdapter
import com.example.newfeeddemoapp.databinding.NewsListBinding
import com.example.newfeeddemoapp.uiListener.INewsListFragmentHandler
import com.example.newfeeddemoapp.viewModel.NewsListViewModel

class NewsListFragment : Fragment(), INewsListFragmentHandler {
    lateinit var newsListViewModel: NewsListViewModel
    private lateinit var newsList: View
    lateinit var newsListBinding: NewsListBinding


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        newsListViewModel = ViewModelProvider(this).get(NewsListViewModel::class.java)
        newsListBinding =
            DataBindingUtil.inflate(
                inflater,
                R.layout.news_list_fragment,
                container,
                false
            )
        newsListBinding.setLifecycleOwner(this)
        newsListBinding.newsListViewModel = newsListViewModel

        newsList = newsListBinding.root
        newsListViewModel.callNewsListApi()
        observerNewsListApi()
        return newsList
    }


    override fun observerNewsListApi() {
        newsListViewModel.newsLiveData?.observe(viewLifecycleOwner, Observer { response ->
            newsListBinding.rvNewsList.layoutManager =
                LinearLayoutManager(context)
            newsListBinding.rvNewsList.layoutManager = LinearLayoutManager(activity)
            newsListBinding.rvNewsList.adapter =
                response.let {
                    NewsListAdapter(
                        it,
                        activity
                    )
                }
        })
    }
}