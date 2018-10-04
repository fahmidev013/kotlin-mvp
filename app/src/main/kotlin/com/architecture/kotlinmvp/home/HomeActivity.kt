package com.architecture.kotlinmvp.home

import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import com.architecture.kotlinmvp.R
import com.architecture.kotlinmvp.home.di.DaggerHomeActivityComponent
import com.base.BaseActivity
import com.architecture.kotlinmvp.home.di.HomeActivityModule
import com.architecture.kotlinmvp.home.model.MarsPhotos
import com.architecture.kotlinmvp.home.model.MarsItem
import com.architecture.kotlinmvp.home.presenter.HomePresenter
import com.architecture.kotlinmvp.home.presenter.HomeView
import com.architecture.kotlinmvp.home.viewholder.MarsViewHolder
import com.burakeregar.easiestgenericrecycleradapter.base.GenericAdapterBuilder
import com.burakeregar.easiestgenericrecycleradapter.base.GenericRecyclerAdapter
import kotlinx.android.synthetic.main.home_activity.*
import org.greenrobot.eventbus.Subscribe
import org.jetbrains.anko.toast
import javax.inject.Inject

class HomeActivity : BaseActivity(), HomeView {

    @Inject
    lateinit var presenter: HomePresenter

    lateinit var adapter: GenericRecyclerAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.home_activity)

        initAdapter()
        presenter.getMarsPhotos()
    }

    private fun initAdapter() {
        adapter = GenericAdapterBuilder().addModel(
                R.layout.row_mars,
                MarsViewHolder::class.java,
                MarsItem::class.java)
                .execute()
        home_rv.layoutManager = LinearLayoutManager(this)
        home_rv.adapter = adapter
    }

    override fun onActivityInject() {
        DaggerHomeActivityComponent.builder().appComponent(getAppcomponent())
                .homeActivityModule(HomeActivityModule())
                .build()
                .inject(this)

        presenter.attachView(this)
    }

    override fun addPhotos(photos: MarsPhotos) {
        adapter.setList(photos.photoList)
    }

    @Subscribe
    fun onRowClicked(item: MarsItem){
        toast("Image Url: ${item.image}")
    }
}
