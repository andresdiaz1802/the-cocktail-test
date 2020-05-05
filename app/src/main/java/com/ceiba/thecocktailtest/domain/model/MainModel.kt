package com.ceiba.thecocktailtest.domain.model

import android.util.Log
import com.ceiba.thecocktailtest.data.api.Retrofit
import com.ceiba.thecocktailtest.data.entities.UserEntity
import com.ceiba.thecocktailtest.domain.interfaces.MainInterface
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainModel(private val presenter: MainInterface.Presenter) : MainInterface.Model,
    Callback<List<UserEntity>> {

    private val repositoryApi: Retrofit = Retrofit()

    override fun select() {
        repositoryApi.userService().users().enqueue(this)
    }

    override fun onFailure(call: Call<List<UserEntity>>, t: Throwable) {
        Log.d(TAG_MESSAGE, "Error: ${t.message}")
    }

    override fun onResponse(call: Call<List<UserEntity>>, response: Response<List<UserEntity>>) {
        if (!response.isSuccessful) {
            Log.d(TAG_MESSAGE, "Error en la petición")
            return
        }
        val users = response.body() ?: emptyList()
        presenter.setUsers(users)
    }

    companion object {
        private const val TAG_MESSAGE = "tag_message"
    }
}