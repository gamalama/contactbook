package com.example.contactbook.network

import com.example.contactbook.data.requests.LoginRequest
import com.example.contactbook.data.responses.LoginResponse
import com.example.contactbook.utils.Constants
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.scalars.ScalarsConverterFactory
import retrofit2.http.*

private const val BASE_URL = "https://phone-book-api.herokuapp.com/api/v1/"

private val retrofit = Retrofit.Builder()
    .addConverterFactory(ScalarsConverterFactory.create())
    .baseUrl(BASE_URL)
    .build()

interface PhoneBookApiService {
    @GET("contacts")
    suspend fun getContacts(@Header("Authorization") token: String): String

    @POST(Constants.LOGIN_URL)
    @FormUrlEncoded
    fun login(@Body request: LoginRequest): Call<LoginResponse>
}

object PhoneBookApi {
    val retrofitService: PhoneBookApiService by lazy {
        retrofit.create(PhoneBookApiService::class.java)
    }
}