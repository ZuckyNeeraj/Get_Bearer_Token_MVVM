package com.example.getbearertokenfromapi.repository

import com.example.getbearertokenfromapi.model.TokenRequest
import com.example.getbearertokenfromapi.model.TokenResponse
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

private const val BASE_URL = "https://simple-books-api.glitch.me"

class ItemRepository(private val tokenRequest: TokenRequest){
    private val api = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()
        .create(ApiInterface::class.java)

    suspend fun getItems(): TokenResponse {
        return api.getToken(tokenRequest)
    }
}
