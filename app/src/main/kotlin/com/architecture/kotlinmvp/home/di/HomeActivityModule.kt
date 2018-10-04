package com.architecture.kotlinmvp.home.di

import com.base.di.ActivityScope
import com.architecture.kotlinmvp.api.Endpoints
import com.architecture.kotlinmvp.home.presenter.HomePresenter
import dagger.Module
import dagger.Provides

@Module
class HomeActivityModule {

    @Provides
    @ActivityScope
    internal fun providesHomePresenter(api: Endpoints): HomePresenter {
        return HomePresenter(api)
    }
}
