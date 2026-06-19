package com.example.spacexapp.ui.launches

import com.example.spacexapp.domain.model.Launch

data class LaunchesUiState (
    val launches: List<Launch> = emptyList(),
    val isLoading: Boolean = false,
    val error: String? = null
)