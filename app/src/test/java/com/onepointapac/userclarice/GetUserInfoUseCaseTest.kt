package com.onepointapac.userclarice

import com.onepointapac.userclarice.data.repository.MockUserService
import com.onepointapac.userclarice.usecase.GetUserInfoUseCase
import kotlinx.coroutines.runBlocking
import org.junit.Assert.assertEquals
import org.junit.Test

class GetUserInfoUseCaseTest {

    private val repository = MockUserService()
    private val useCase = GetUserInfoUseCase(repository)

    @Test
    fun `getUserInfo returns success with correct user`() = runBlocking {
        val result = useCase()

        assertEquals(true, result.isSuccess)
        assertEquals("Tom", result.getOrNull()?.name)
    }
}
