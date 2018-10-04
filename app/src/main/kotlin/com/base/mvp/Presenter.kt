package com.base.mvp

/**
* Created by Fahmi Hakim on 23.05.2017.
 */
interface Presenter<V : BaseView> {

    fun attachView(view: V)

    fun detachView()
}