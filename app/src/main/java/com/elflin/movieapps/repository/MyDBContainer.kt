package com.elflin.movieapps.repository

import com.elflin.movieapps.service.MovieDBServices
import com.elflin.movieapps.service.MyDBService
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MyDBContainer {
    companion object{
        val BASE_IMG = ""
        var ACCESS_TOKEN = ""
    }

    private val BASE_URL = "https://172.20.10.3/laravel_vp_api_2023/public/api/"

    private val client = OkHttpClient.Builder()
        .addInterceptor(AuthInterceptor(ACCESS_TOKEN))
        .build()

    private val retrofit = Retrofit.Builder()
        .addConverterFactory(GsonConverterFactory.create())
        .baseUrl(BASE_URL)
        .client(client)
        .build()

    private val retrofitService: MyDBService by lazy{
        retrofit.create(MyDBService::class.java)
    }

    val myDBRepositories: MyDBRepositories by lazy{
        MyDBRepositories(retrofitService)
    }
}