package com.base.helper

import android.content.SharedPreferences
import com.google.gson.Gson

/**
* Created by Fahmi Hakim on 23.05.2017.
 */
class SpHelper constructor(var sharedPreferences: SharedPreferences, var gson: Gson) {

    private var editor: SharedPreferences.Editor = sharedPreferences.edit()

//    @Synchronized fun setModel(offlineTourData: YourModel) {
//        putDatatoSharedPref(gson.toJsonTree(offlineTourData, YourModel::class.java)
//                .toString(), String::class.java, "keyForModel")
//
//    }
//
//    @Synchronized fun getModel(): YourModel {
//        return gson.fromJson((getDataFromSharedPref(String::class.java, "savedTours"))
//                as String?, YourModel::class.java)
//    }

    @Synchronized
    fun <T> getDataFromSharedPref(dataType: Class<T>, key: String): Any? =
            when (dataType) {
                Int::class.java -> sharedPreferences.getInt(key, 0)
                String::class.java -> sharedPreferences.getString(key, null)
                Long::class.java -> sharedPreferences.getLong(key, 0)
                Boolean::class.java -> sharedPreferences.getBoolean(key, false)
                else -> null
            }

    @Synchronized
    fun <T> putDatatoSharedPref(data: T, dataType: Class<*>, key: String) {
        when (dataType) {
            Int::class.java -> editor.putInt(key, data as Int)
            String::class.java -> editor.putString(key, data as String)
            Long::class.java -> editor.putLong(key, data as Long)
            Boolean::class.java -> editor.putBoolean(key, data as Boolean)
        }
        editor.commit()
    }
}