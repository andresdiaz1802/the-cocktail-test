package com.ceiba.thecocktailtest.domain.interfaces

import com.ceiba.thecocktailtest.data.entities.UserEntity

interface MainInterface {
    interface View {
        fun initialObjects()
        fun initialElements()
        fun setUsers(users:List<UserEntity>)
    }

    interface Presenter {
        fun initial()
        fun select()
        fun setUsers(users:List<UserEntity>)
    }

    interface Model {
        fun select()
    }
}