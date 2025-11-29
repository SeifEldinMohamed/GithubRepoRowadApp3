package com.seif.firstcomposeapp.ui.screens.issues_screen

import com.seif.firstcomposeapp.ui.model.CustomExceptionUiModel
import com.seif.firstcomposeapp.ui.screens.issues_screen.model.IssuesUiModel


data class IssuesUiState(
    val issuesList: List<IssuesUiModel>? = null,
    val isLoading: Boolean = false,
    val isError: Boolean = false,
    val customErrorExceptionUiModel: CustomExceptionUiModel = CustomExceptionUiModel.Unknown
)