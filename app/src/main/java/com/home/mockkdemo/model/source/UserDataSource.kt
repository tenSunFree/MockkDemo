package com.home.mockkdemo.model.source

import com.home.mockkdemo.model.UserPojo

interface UserDataSource {

    fun getUser(id: Int): UserPojo?
}