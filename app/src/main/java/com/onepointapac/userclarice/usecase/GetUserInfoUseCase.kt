package com.onepointapac.userclarice.usecase

import com.onepointapac.userclarice.data.repository.UserRepository
import com.onepointapac.userclarice.data.model.User

class GetUserInfoUseCase(
    private val repository: UserRepository
) {
    suspend operator fun invoke(): Result<User> = repository.getUserInfo()
}