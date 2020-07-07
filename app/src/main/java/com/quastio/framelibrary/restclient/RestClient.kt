package com.quastio.framelibrary.restclient

import com.google.gson.GsonBuilder
import com.google.gson.JsonElement
import com.quastio.framelibrary.models.Data
import com.quastio.framelibrary.models.RedditResponse
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import java.util.concurrent.TimeUnit

object RestClient {
    private const val BASE_URL="https://www.reddit.com/r/images/"

    private val defaultHttpClient: OkHttpClient by lazy {
        OkHttpClient.Builder()
            .writeTimeout(10, TimeUnit.SECONDS)
            .readTimeout(10, TimeUnit.SECONDS)
            .connectTimeout(20, TimeUnit.SECONDS)
            .build()
    }
    private val retrofitBuilder: Retrofit.Builder by lazy {
        Retrofit.Builder()
            .client(defaultHttpClient)
            .baseUrl(BASE_URL)
            .addConverterFactory(
                GsonConverterFactory.create(
                    GsonBuilder()
                        .setDateFormat("yyyy-MM-dd'T'HH:mm:ssZ")
                        .create()))

    }

    val apiService:ApiService by lazy {
        retrofitBuilder.build().create(ApiService::class.java)
    }



    interface ApiService{
        @GET("hot.json")
        suspend fun getJson():RedditResponse

    }}