package com.example.canvastraining.domain

import javax.inject.Inject

class UseCases @Inject constructor(
    private val addRecordUseCase: AddRecordUseCase,
    private val deleteRecordUseCase: DeleteRecordUseCase,
    private val updateRecordUseCase: UpdateRecordUseCase,
    private val getAllRecordsUseCase: GetAllRecordsUseCase
)