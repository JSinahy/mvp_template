package com.jsle.mvptemplate.data.net

import com.jsle.mvptemplate.presentation.models.Modelo
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiServices {
    @GET("")
    fun getMethos(@Query("") VARIABLE: String): Call<Modelo>
}