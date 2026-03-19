package com.onepointapac.userclarice.data.repository

import com.onepointapac.userclarice.data.model.User

interface UserRepository {

    suspend fun getUserInfo(): Result<User>
    suspend fun getUserList(): Result<List<User>>

}