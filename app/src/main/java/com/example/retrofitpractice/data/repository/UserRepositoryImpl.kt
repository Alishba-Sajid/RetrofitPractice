package com.example.retrofitpractice.data.repository

import com.example.retrofitpractice.data.remote.ApiService
import com.example.retrofitpractice.domain.model.User
import com.example.retrofitpractice.domain.repository.UserRepository
import javax.inject.Inject

class UserRepositoryImpl @Inject constructor(
    private val apiService: ApiService
) : UserRepository {

    override suspend fun getUsers(): List<User> {
        return apiService.getUsers()
    }
}
