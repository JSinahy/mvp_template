package com.jsle.mvptemplate.domain

import com.jsle.mvptemplate.BuildConfig
import com.jsle.mvptemplate.data.net.ApiServices
import com.jsle.mvptemplate.presentation.models.Modelo
import com.jsle.mvptemplate.utils.UtilLog
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class ActivityDetailInteractor {
    companion object {
        const val TAG: String = "ApodDetailInteractor"
        const val BASE_URL = "https://api.nasa.gov/planetary/"
    }

    interface onDetailsFetched {
        fun onSuccess(apodFetchedData : Modelo)
        fun onFailure()
    }

    fun getApodDataFromRemote(listener : onDetailsFetched){

        val retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        val service = retrofit.create(ApiServices::class.java)
        service.getMethos("API_KEY")
            .enqueue(object : Callback<Modelo> {
                override fun onResponse(call: Call<Modelo>, response: Response<Modelo>) {
                    if (!response.isSuccessful) {
                        listener.onFailure()
                        return
                    }

                    val apodData = response.body()

                    if (apodData != null)
                        listener.onSuccess(apodData)
                }

                override fun onFailure(call: Call<Modelo>, t: Throwable) {
                    listener.onFailure()
                    UtilLog.print(TAG, "onFailure: " + t.cause)
                }
            })

    }
}