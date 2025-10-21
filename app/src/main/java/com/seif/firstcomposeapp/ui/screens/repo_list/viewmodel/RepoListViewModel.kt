package com.seif.firstcomposeapp.ui.screens.repo_list.viewmodel

import androidx.lifecycle.ViewModel
import com.seif.firstcomposeapp.domain.usecase.FetchGithubReposUseCase

class RepoListViewModel(
    private val fetchGithubReposUseCase: FetchGithubReposUseCase
) : ViewModel() {

    fun fetchGithubRepos(){
        fetchGithubReposUseCase.invoke()
    }
}

// screen -> viewmodel -> usecase -> repository -> remoteDataSource -> Api