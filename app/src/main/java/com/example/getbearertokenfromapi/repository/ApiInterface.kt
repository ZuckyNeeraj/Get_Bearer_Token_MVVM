package com.example.getbearertokenfromapi.repository

import com.example.getbearertokenfromapi.model.TokenRequest
import com.example.getbearertokenfromapi.model.TokenResponse
import retrofit2.http.Body
import retrofit2.http.POST

interface ApiInterface {

    @POST("/api-clients/")
    suspend fun getToken(@Body tokenRequest: TokenRequest): TokenResponse
}
