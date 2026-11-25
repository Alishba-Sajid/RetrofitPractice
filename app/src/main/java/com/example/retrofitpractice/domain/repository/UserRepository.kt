package com.example.retrofitpractice.domain.repository

import com.example.retrofitpractice.domain.model.User

interface UserRepository {

    suspend fun getUsers(): List<User>

}
