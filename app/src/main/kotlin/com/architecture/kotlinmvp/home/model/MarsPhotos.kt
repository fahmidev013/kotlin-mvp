package com.architecture.kotlinmvp.home.model

import com.google.gson.annotations.SerializedName

/**
 * Created by Fahmi Hakim on 23.05.2017.
 */
data class MarsPhotos(@SerializedName("photos") var photoList: ArrayList<MarsItem>)
