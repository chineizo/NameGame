package com.example.namegame.model

sealed class NameGameResponse {
    data class Success(val data: List<NameGame>) : NameGameResponse()
    data class Failure(val exception: String?) : NameGameResponse()
    class Loading(val message: String) : NameGameResponse()
}
