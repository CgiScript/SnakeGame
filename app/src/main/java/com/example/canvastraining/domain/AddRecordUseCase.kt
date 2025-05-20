package com.example.canvastraining.domain

import com.example.canvastraining.data.Record
import com.example.canvastraining.data.RecordRepository
import javax.inject.Inject

class AddRecordUseCase @Inject constructor(
    private val recordRepository: RecordRepository
){
    suspend fun execute(record: Record){
        recordRepository.addRecord(record)
    }
}