package com.ayush.homeautomation

import retrofit2.Call
import retrofit2.Response
import retrofit2.http.GET

interface ApiInterface {
    @GET("ChangeState")
    suspend fun getData(): Response<MyData>
}