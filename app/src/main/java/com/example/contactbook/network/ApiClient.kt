package com.example.contactbook.network

import com.example.contactbook.utils.Constants
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class ApiClient {
    private lateinit var apiService: PhoneBookApiService

    fun getApiService(): PhoneBookApiService {
        if (!::apiService.isInitialized) {
            val retrofit = Retrofit.Builder()
                .baseUrl(Constants.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()

            apiService = retrofit.create(PhoneBookApiService::class.java)
        }
        return apiService
    }
}