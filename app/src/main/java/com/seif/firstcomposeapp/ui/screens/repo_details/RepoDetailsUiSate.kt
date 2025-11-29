package com.seif.firstcomposeapp.ui.screens.repo_details

import com.seif.firstcomposeapp.ui.screens.repo_list.model.RepoDetailsUiModel

data class RepoDetailsUiState(
    val repoDetailsUiModel: RepoDetailsUiModel? = null,
    val isLoading: Boolean = false,
    val isError: Boolean = false,
    val errorMessage: String = ""
)