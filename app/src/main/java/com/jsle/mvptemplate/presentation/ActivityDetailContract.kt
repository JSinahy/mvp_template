package com.jsle.mvptemplate.presentation

import com.jsle.mvptemplate.presentation.models.Modelo

interface ActivityDetailContract {
    interface View{
        fun showProgressBar()
        fun hideProgressBar()
        fun hideActivity()
        fun showActivity()
        fun showActivityDetail(modelo: Modelo)
        fun fetchActivityDetail()
        fun showDataFetchError()
        fun reloadData()
        fun expandActivityImage()
        fun showActivityImageProgressBar()
        fun hideActivityImageProgressBar()
    }

    interface Presenter{
        fun fetchData()
    }
}