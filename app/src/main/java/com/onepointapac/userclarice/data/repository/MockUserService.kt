package com.onepointapac.userclarice.data.repository

import com.onepointapac.userclarice.data.model.User

class MockUserService: UserRepository {

    val userA: User = User(
        id = 1,
        name = "Tom"
    )

    val userB: User = User(
        id = 1,
        name = "Tom"
    )

    override  suspend fun getUserInfo(): Result<User> {
        return Result.success(userA)
    }

    override suspend fun getUserList(): Result<List<User>> {
        return Result.success(listOf(userA, userB))
    }
}