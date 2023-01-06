package com.example.egardia_mobile_development_assessment.data.datasource.api

import com.example.egardia_mobile_development_assessment.data.model.Cars
import okhttp3.ResponseBody
import retrofit2.http.GET

interface ApiService {
    @GET("beckershoff/Egardia-Mobile-Development-Assessment/master/cars.json")
    suspend fun getAllCars():Cars
}