package com.example.canvastraining.ui.highscores

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.canvastraining.data.Record
import com.example.canvastraining.domain.UseCases
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class HighScoresViewModel @Inject constructor(
    private val useCase:UseCases
): ViewModel(){

    val recordList = MutableStateFlow<List<Record>>(emptyList())
    var isEmpty = mutableStateOf(false)

    init{
        getAllRecords()
    }

    fun getAllRecords(){
        viewModelScope.launch {
            useCase.getAllRecordsUseCase.execute().collect{
                it.ifEmpty {
                    isEmpty.value = true
                    return@collect
                }
                recordList.value = it
            }
        }
    }

    fun deleteAllRecords(){
        viewModelScope.launch {
            useCase.deleteAllRecordsUseCase.execute()
        }
    }

}