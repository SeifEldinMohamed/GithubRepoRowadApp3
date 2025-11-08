package com.seif.firstcomposeapp.ui.screens.repo_list

import com.seif.firstcomposeapp.ui.screens.repo_list.model.GithubReposUiModel

sealed class RepoListUiState {
    data object InitialState:RepoListUiState()
    data class Loading(val isLoading: Boolean): RepoListUiState()
    data class RepoList(val repoList: List<GithubReposUiModel>): RepoListUiState()
    data class Error(val message: String): RepoListUiState()
}