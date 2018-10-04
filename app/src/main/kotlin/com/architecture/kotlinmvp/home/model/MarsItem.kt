package com.architecture.kotlinmvp.home.model

import com.google.gson.annotations.SerializedName

/**
 * Created by Fahmi Hakim on 23.05.2017.
 */

data class MarsItem(@SerializedName("img_src") var image: String, @SerializedName("earth_date") var date: String)