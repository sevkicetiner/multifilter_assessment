package com.example.egardia_mobile_development_assessment.data.datasource.api

import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class ApiClient {
    private val BASE_URL = "https://raw.githubusercontent.com/"
    var client: OkHttpClient = OkHttpClient.Builder().build()
    fun getService(): ApiService {
        return Retrofit.Builder().baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .client(client)
            .build()
            .create(ApiService::class.java)
    }
}