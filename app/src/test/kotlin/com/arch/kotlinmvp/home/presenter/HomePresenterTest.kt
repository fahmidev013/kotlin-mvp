package com.arch.kotlinmvp.home.presenter

import com.architecture.kotlinmvp.api.Endpoints
import com.architecture.kotlinmvp.home.model.MarsPhotos
import com.architecture.kotlinmvp.home.presenter.HomePresenter
import com.architecture.kotlinmvp.home.presenter.HomeView
import com.nhaarman.mockito_kotlin.any
import com.nhaarman.mockito_kotlin.doAnswer
import com.nhaarman.mockito_kotlin.mock
import org.junit.Test

import org.junit.Before
import org.mockito.Mockito.`when`
import org.mockito.Mockito.verify
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

/**
* Created by Fahmi Hakim on 23.05.2017.
*/

class HomePresenterTest {

    private val view: HomeView = mock()
    private val api: Endpoints = mock()
    private lateinit var presenter: HomePresenter

    @Before
    fun setup(){
        presenter = HomePresenter(api)
        presenter.attachView(view)
    }

    @Test
    fun test_getMarsPhotos_should_callSuccess() {
        val mockedCall: Call<MarsPhotos> = mock()
        val mockedResponse: MarsPhotos = mock()

        `when`(api.getMarsPhotos()).thenReturn(mockedCall)

        doAnswer {
            val callBack: Callback<MarsPhotos> = it.getArgument(0)

            callBack.onResponse(mockedCall, Response.success(mockedResponse))
        }.`when`(mockedCall).enqueue(any())

        presenter.getMarsPhotos()

        verify(view).addPhotos(mockedResponse)

    }

    @Test
    fun test_getMarsPhotos_should_callError() {
        val mockCall: Call<MarsPhotos> = mock()
        val mockThrowable: Throwable = mock()

        `when`(api.getMarsPhotos()).thenReturn(mockCall)

        doAnswer {
            val callBack: Callback<MarsPhotos> = it.getArgument(0)

            callBack.onFailure(mockCall, mockThrowable)
        }.`when`(mockCall).enqueue(any())

        presenter.getMarsPhotos()

        verify(view).onError()

    }

}