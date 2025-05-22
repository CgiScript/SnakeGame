package com.example.canvastraining.domain

import com.example.canvastraining.data.Record
import com.example.canvastraining.data.RecordRepository
import javax.inject.Inject

class DeleteAllRecordsUseCase @Inject constructor(
    private val recordRepository: RecordRepository
){
    suspend fun execute(){
        recordRepository.deleteAllRecords()
    }
}