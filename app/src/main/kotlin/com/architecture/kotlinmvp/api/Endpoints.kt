package com.architecture.kotlinmvp.api

import com.architecture.kotlinmvp.home.model.MarsPhotos
import retrofit2.Call
import retrofit2.http.GET

/**
 * Created by Fahmi Hakim on 23.05.2017.
 */
interface Endpoints {
    @GET("rovers/curiosity/photos?sol=50&page=5&api_key=DEMO_KEY")
    fun getMarsPhotos(): Call<MarsPhotos>
}