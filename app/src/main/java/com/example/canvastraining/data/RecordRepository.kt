package com.example.canvastraining.data

import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class RecordRepository @Inject constructor(private val recordDao: RecordDao) {

    suspend fun addRecord(record: Record){
        recordDao.insertRecord(record)
    }

    suspend fun deleteRecord(record: Record){
        recordDao.deleteRecord(record)
    }

    suspend fun updateRecord(record: Record){
        recordDao.updateRecord(record)
    }

    fun getAllRecords():  Flow<List<Record>> {
        return recordDao.getAllRecords()
    }

    suspend fun deleteAllRecords(){
        recordDao.deleteAllRecords()
    }
}