package com.base.mvp

/**
 * Created by Fahmi Hakim on 23.05.2017.
 */
interface BaseView {
    fun onError()
    fun setPresenter(presenter: BasePresenter<*>)
}