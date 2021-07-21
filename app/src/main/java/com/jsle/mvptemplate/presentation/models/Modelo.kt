package com.jsle.mvptemplate.presentation.models

import com.google.gson.annotations.SerializedName

data class Modelo(val explanation: String = "",
                  val hdurl: String = "",
                  @SerializedName("url") val lowresurl: String = "",
                  val title: String = "",
                  val date: String = "",
                  val copyright: String = "")