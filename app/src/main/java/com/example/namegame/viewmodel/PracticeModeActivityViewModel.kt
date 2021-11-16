package com.example.namegame.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.liveData
import com.example.namegame.model.NameGameResponse
import com.example.namegame.repository.NameGameRepository
import kotlinx.coroutines.Dispatchers
import java.lang.IllegalArgumentException

class PracticeActivityViewModel(private val nameGameRepository: NameGameRepository) : ViewModel() {

    fun getNameGame() = liveData(Dispatchers.IO) {
        try {
            emit(
                NameGameResponse.Success(
                    nameGameRepository.getNameGame()
                )
            )
        } catch (exception: Exception) {
            emit(NameGameResponse.Failure(exception.message))
        }
    }
}

/**
 * Factory class to produce an instance of MainActivityViewModel
 */
internal class PracticeModeActivityViewModelFactory(private val nameGameRepository: NameGameRepository) :
    ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(PracticeActivityViewModel::class.java)) {
            return PracticeActivityViewModel(nameGameRepository) as T
        }
        throw IllegalArgumentException("Unknown class name seen")
    }
}