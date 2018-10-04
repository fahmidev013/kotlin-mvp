package com.burakeregar.kotlinmvparchitecture.home.model

import com.google.gson.annotations.SerializedName

/**
 * Created by Burak Eregar on 23.05.2017.
 * burakeregar@gmail.com
 * https://github.com/burakeregar
 */
data class MarsPhotos(@SerializedName("photos") var photoList: ArrayList<MarsItem>)
