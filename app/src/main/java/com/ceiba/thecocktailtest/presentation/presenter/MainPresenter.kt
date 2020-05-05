package com.ceiba.thecocktailtest.presentation.presenter

import com.ceiba.thecocktailtest.data.entities.UserEntity
import com.ceiba.thecocktailtest.domain.interfaces.MainInterface
import com.ceiba.thecocktailtest.domain.model.MainModel

class MainPresenter(private val view: MainInterface.View) : MainInterface.Presenter {
    private val model: MainInterface.Model = MainModel(this)
    override fun initial() {
        view.initialObjects()
        view.initialElements()
        model.select()
    }

    override fun select() {
        model.select()
    }

    override fun setUsers(users: List<UserEntity>) {
        view.setUsers(users)
    }
}