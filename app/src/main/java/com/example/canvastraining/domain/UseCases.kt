package com.example.canvastraining.domain

import javax.inject.Inject

class UseCases @Inject constructor(
    val addRecordUseCase: AddRecordUseCase,
    val deleteRecordUseCase: DeleteRecordUseCase,
    val updateRecordUseCase: UpdateRecordUseCase,
    val getAllRecordsUseCase: GetAllRecordsUseCase,
    val deleteAllRecordsUseCase: DeleteAllRecordsUseCase
)