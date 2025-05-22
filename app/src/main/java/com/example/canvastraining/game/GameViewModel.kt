package com.example.canvastraining.game


import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.canvastraining.data.Record
import com.example.canvastraining.domain.UseCases
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import java.time.LocalDate
import javax.inject.Inject

@HiltViewModel
class GameViewModel @Inject constructor(private val useCases: UseCases):ViewModel(){

    var isEmpty = false
    val recordList = MutableStateFlow<List<Record>>(emptyList())


    init {
        getAllRecords()
    }

    fun getAllRecords(){
       viewModelScope.launch {
           useCases.getAllRecordsUseCase.execute().collect{
               if (it.isEmpty()){
                  isEmpty = true
                  return@collect
               }
               recordList.value = it
           }
       }
    }

    fun addNewRecord(userName: String, highScore: Int){
        viewModelScope.launch {
            useCases.addRecordUseCase.execute(
                Record(
                    userName = userName,
                    highScore = highScore,
                    recordDate = LocalDate.now().toString()
                )
            )
        }
    }

    fun deleteAllRecords(){
        viewModelScope.launch {
            useCases.deleteAllRecordsUseCase.execute()
        }
    }
}