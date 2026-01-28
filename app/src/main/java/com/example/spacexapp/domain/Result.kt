package com.example.spacexapp.domain

// Explicitly handles success/error/loading states
// Type-safe - compiler ensures handle all cases
sealed class Result<out T> {
    data class Success<T>(val data: T) : Result<T>()
    data class Error(val message: String) : Result<Nothing>()
    data object Loading : Result<Nothing>()
}