package com.example.spacexapp.ui.detail

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.spacexapp.data.repository.LaunchRepository
import com.example.spacexapp.domain.model.Launch
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn
import javax.inject.Inject

@HiltViewModel
class DetailViewModel @Inject constructor(
    savedStateHandle: SavedStateHandle,
    private val repository: LaunchRepository
): ViewModel() {
    private val launchId: String = savedStateHandle["launchId"] ?: ""

    val launch: StateFlow<Launch?> = repository.getLaunchById(launchId)
        .map { it }
        .stateIn(
            scope = viewModelScope,
            started = SharingStarted.WhileSubscribed(5000),
            initialValue = null
        )

}