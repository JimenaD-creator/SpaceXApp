package com.example.spacexapp.ui.launches

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.spacexapp.data.repository.LaunchRepository
import com.example.spacexapp.domain.Result
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

// Hilt knows how to create this ViewModel and inject Repository
@HiltViewModel
class LaunchesViewModel @Inject constructor(
    private val repository: LaunchRepository
): ViewModel(){
    // Internal, mutable state
    private val _uiState = MutableStateFlow(LaunchesUiState())
    //Public, read-only state (protection)
    val uiState: StateFlow<LaunchesUiState> = _uiState.asStateFlow()

    init {
        loadLaunches()
    }

    fun loadLaunches(forceRefresh: Boolean = false){
        //Coroutines are cancelled when ViewModel is cleared (no memory leaks)
        viewModelScope.launch {
            repository.getLatestLaunches(forceRefresh).collect { result ->
                when (result) {
                    is Result.Loading -> {
                        _uiState.update { it.copy(isLoading = true) }
                    }
                    is Result.Success -> {
                        //Safe way to modify state (thread-safe)
                        _uiState.update {
                            it.copy(
                                launches = result.data,
                                isLoading = false,
                                error = null
                            )
                        }
                    }
                    is Result.Error -> {
                        _uiState.update {
                            it.copy(
                                isLoading = false,
                                error = result.message
                            )
                        }
                    }
                }
           }

        }
    }

    fun refreshLaunches(){
        loadLaunches(forceRefresh = true)
    }
}