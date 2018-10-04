package com.architecture.kotlinmvp.home.presenter

import com.base.mvp.BaseView
import com.architecture.kotlinmvp.home.model.MarsPhotos

interface HomeView : BaseView {
    fun addPhotos(photos: MarsPhotos)
}
