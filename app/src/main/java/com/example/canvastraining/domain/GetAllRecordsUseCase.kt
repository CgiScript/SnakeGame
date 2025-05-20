package com.example.canvastraining.domain

import com.example.canvastraining.data.Record
import com.example.canvastraining.data.RecordRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetAllRecordsUseCase @Inject constructor(
    private val recordRepository: RecordRepository
){
    fun execute(): Flow<List<Record>> {
        return recordRepository.getAllRecords()
    }
}