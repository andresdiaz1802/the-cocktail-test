package com.ceiba.thecocktailtest.data.api

import com.ceiba.thecocktailtest.data.entities.UserEntity
import retrofit2.Call
import retrofit2.http.GET

interface UserDao {

    @GET("users/")
    fun users(): Call<List<UserEntity>>
}