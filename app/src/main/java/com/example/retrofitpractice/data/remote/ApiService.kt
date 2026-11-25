package com.example.retrofitpractice.data.remote

import com.example.retrofitpractice.domain.model.User
import retrofit2.http.GET

interface ApiService {

    @GET("users")
    suspend fun getUsers(): List<User>

}