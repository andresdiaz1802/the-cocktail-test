package com.ceiba.thecocktailtest.presentation.view

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.ceiba.thecocktailtest.R
import com.ceiba.thecocktailtest.data.entities.UserEntity
import com.ceiba.thecocktailtest.domain.interfaces.MainInterface
import com.ceiba.thecocktailtest.presentation.view.adapter.UserAdapter
import com.ceiba.thecocktailtest.presentation.presenter.MainPresenter
import com.google.gson.Gson

class MainActivity : AppCompatActivity(), MainInterface.View {

    private lateinit var recyclerView: RecyclerView

    private lateinit var adapter: UserAdapter
    private lateinit var presenter: MainInterface.Presenter
    private val users: ArrayList<UserEntity> = ArrayList()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        presenter = MainPresenter(this)
        presenter.initial()
    }

    override fun initialObjects() {
        adapter = UserAdapter(users)
    }

    override fun initialElements() {
        recyclerView = findViewById(R.id.recycler_view)
        recyclerView.setHasFixedSize(true)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = adapter
    }

    override fun setUsers(users: List<UserEntity>) {
        this.users.addAll(users)
        adapter.notifyDataSetChanged()
        Log.d("Message", Gson().toJson(users))
    }
}
