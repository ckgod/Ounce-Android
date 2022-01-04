package com.example.ounceaos

import android.app.Application
import android.content.Context
import android.content.SharedPreferences

class ApplicationClass : Application() {

    override fun onCreate() {
        super.onCreate()
        instance = this

        if (jwtToken == null) {
            jwtToken = applicationContext.getSharedPreferences(X_ACCESS_TOKEN, Context.MODE_PRIVATE)
        }

    }

    override fun onTerminate() {
        super.onTerminate()
        instance = null
    }

    companion object {  // Retrofit 인스턴스
        const val TAG = "ApplicationClass"

        var emailPattern: String = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+"

        var X_ACCESS_TOKEN = "X-ACCESS-TOKEN"
        var instance: ApplicationClass? = null
        // jwt Token 저장
        var jwtToken: SharedPreferences? = null
    }
}