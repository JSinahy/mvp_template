package com.jsle.mvptemplate.utils


import android.util.Log
import com.jsle.mvptemplate.BuildConfig

class UtilLog {
    companion object{
        fun print(title: String, body: String){
            if(!BuildConfig.ENVIRONMENT.equals("PRO")){
                Log.wtf(title, body)
            }
        }
    }
}