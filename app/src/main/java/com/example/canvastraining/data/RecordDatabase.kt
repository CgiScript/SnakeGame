package com.example.canvastraining.data

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [Record::class], version = 1)
abstract class RecordDatabase: RoomDatabase(){
    abstract fun recordDao(): RecordDao
}
