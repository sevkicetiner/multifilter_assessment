package com.example.egardia_mobile_development_assessment.data

import com.example.egardia_mobile_development_assessment.data.datasource.api.ApiClient
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class Repository {
   suspend fun getAllCars()= ApiClient().getService().getAllCars()
}