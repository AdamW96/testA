package com.onepointapac.userclarice.presentation.dashboard

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import com.onepointapac.userclarice.data.model.User
import com.onepointapac.userclarice.data.repository.MockUserService
import com.onepointapac.userclarice.usecase.GetUserInfoUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

data class DashboardStatus(
    val isLoading: Boolean = true,
    val user: User? = null,
)

class DashboardViewModel(
    private val getUserInfoUseCase: GetUserInfoUseCase
): ViewModel() {


    private val _uiStatus = MutableStateFlow(DashboardStatus())
    val status = _uiStatus.asStateFlow()

    fun loadUser() {
        viewModelScope.launch {
            val result = getUserInfoUseCase()
            _uiStatus.update { it.copy(isLoading = false, user = result.getOrNull()) }
        }
    }

    companion object {

        val Factory: ViewModelProvider.Factory = object : ViewModelProvider.Factory {
            @Suppress("UNCHECKED_CAST")
            override fun <T : ViewModel> create(
                modelClass: Class<T>,
            ): T {
                val userRepository = MockUserService()
                return DashboardViewModel(GetUserInfoUseCase(userRepository)) as T
            }
        }
    }
}