package com.onepointapac.userclarice.presentation.dashboard

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel

@Composable
fun DashboardScreen(
    modifier: Modifier = Modifier,
    viewModel: DashboardViewModel = viewModel(factory = DashboardViewModel.Factory),
) {
    val status by viewModel.status.collectAsState()

    LaunchedEffect(Unit) { viewModel.loadUser() }

    Box(
        modifier = modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        if (status.isLoading) {
            CircularProgressIndicator()
        } else {
            status.user?.let { user ->
                Column(horizontalAlignment = Alignment.CenterHorizontally) {
                    Text(text = "ID: ${user.getUserId}")
                    Text(text = "Name: ${user.getUserName}")
                }
            }
        }
    }
}
