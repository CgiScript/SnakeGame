package com.example.canvastraining.data

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Record(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    @ColumnInfo(name = "username") val userName: String,
    @ColumnInfo(name = "highscore") val highScore: Int,
    @ColumnInfo(name = "date") val recordDate: String,
)