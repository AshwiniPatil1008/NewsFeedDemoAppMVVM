package com.example.newfeeddemoapp.viewModel

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import com.example.newfeeddemoapp.Util.Utils
import com.example.newfeeddemoapp.Models.News
import com.example.newfeeddemoapp.Models.TotalNews
import com.example.newfeeddemoapp.networkServices.ApiClient
import com.example.newfeeddemoapp.networkServices.ApiInterface
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class NewsListViewModel(application: Application) : AndroidViewModel(application) {
    var mContext: Application
    val newsLiveData: MutableLiveData<List<News>>? = MutableLiveData()


    init {
        mContext = application
    }

    fun callNewsListApi() {

        val apiService: ApiInterface = ApiClient.getClient().create(ApiInterface::class.java)
        var call = apiService.getNewsList("in", Utils.APIKEY)

        call?.enqueue(object : Callback<TotalNews> {

            override fun onResponse(call: Call<TotalNews>?, response: Response<TotalNews>?) {

                Log.v("Response================", response?.body().toString())
                if (response!!.body() != null) {
                    newsLiveData!!.value = response.body()?.newsList

                }

            }

            override fun onFailure(call: Call<TotalNews>?, t: Throwable?) {
                Log.v("Error=============", t.toString())
            }
        })
    }

}