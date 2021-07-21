package com.jsle.mvptemplate.presentation.presenter

import com.jsle.mvptemplate.base.BasePresenter
import com.jsle.mvptemplate.domain.ActivityDetailInteractor
import com.jsle.mvptemplate.presentation.ActivityDetailContract
import com.jsle.mvptemplate.presentation.models.Modelo

class ActivityDetailPresenter constructor(view: ActivityDetailContract.View, detailInteractor: ActivityDetailInteractor):
    BasePresenter(), ActivityDetailContract.Presenter {

    var view: ActivityDetailContract.View? = null
    var dataInteractor: ActivityDetailInteractor? = null

    init{
        this.view = view
        this.dataInteractor = dataInteractor
    }



    override fun fetchData() {
        view?.hideActivity()
        view?.showProgressBar()
        dataInteractor?.getApodDataFromRemote(object: ActivityDetailInteractor.onDetailsFetched {
            override fun onSuccess(apodFetchedData: Modelo) {
                view?.hideProgressBar()
                view?.showActivity()
                view?.showActivityDetail(apodFetchedData)
            }

            override fun onFailure() {
                view?.showDataFetchError()
                view?.hideProgressBar()
            }

        })
    }
}