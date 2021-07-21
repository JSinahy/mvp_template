package com.jsle.mvptemplate.base

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.annotation.Nullable
import androidx.appcompat.app.AppCompatActivity

abstract class BaseActivity<Presenter : BasePresenter> : AppCompatActivity() {

    protected lateinit var presenter: Presenter

    protected abstract fun createPresenter(context: Context): Presenter

    override fun onCreate(savedInstanceState: Bundle?){
        super.onCreate(savedInstanceState)
        presenter = createPresenter(this)
        presenter.onCreate(savedInstanceState)
    }

    override fun onPause(){
        super.onPause()
        presenter.onPause()
    }

    override fun onResume(){
        super.onResume()
        presenter.onResume()
    }

    override fun onDestroy(){
        super.onDestroy()
        presenter.onDestroy()
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, @Nullable data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        presenter.onActivityResult(requestCode, resultCode, data)
    }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        presenter.onRequestPermissionsResult(requestCode, permissions as Array<String>, grantResults)
    }
}