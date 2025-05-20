package com.example.canvastraining.di

import android.content.Context
import androidx.room.Room
import com.example.canvastraining.data.RecordDao
import com.example.canvastraining.data.RecordDatabase
import com.example.canvastraining.data.RecordRepository
import com.example.canvastraining.domain.AddRecordUseCase
import com.example.canvastraining.domain.DeleteRecordUseCase
import com.example.canvastraining.domain.GetAllRecordsUseCase
import com.example.canvastraining.domain.UpdateRecordUseCase
import com.example.canvastraining.domain.UseCases
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideDB(@ApplicationContext context:Context):RecordDatabase{
        return Room.databaseBuilder(
            context,
            RecordDatabase::class.java,
            "record_db"
        ).build()
    }

    @Provides
    fun provideRecordDao(db:RecordDatabase): RecordDao{
        return db.recordDao()
    }

    @Provides
    fun provideUseCases(repo: RecordRepository):UseCases{
        return UseCases(
            AddRecordUseCase(repo),
            DeleteRecordUseCase(repo),
            UpdateRecordUseCase(repo),
            GetAllRecordsUseCase(repo),
        )
    }

}