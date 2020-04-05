package com.home.mockkdemo.model.source

import com.home.mockkdemo.model.FakeUserData
import com.home.mockkdemo.model.UserPojo

class UserRemoteDataSource : UserDataSource {

    private var userMap = LinkedHashMap<Int, UserPojo>(FakeUserData.userArray.size)

    init {
        for (user in FakeUserData.userArray) {
            addUser(user)
        }
    }

    override fun getUser(id: Int): UserPojo? {
        return userMap[id]
    }

    private fun addUser(user: UserPojo) {
        userMap[user.id] = user
    }
}














