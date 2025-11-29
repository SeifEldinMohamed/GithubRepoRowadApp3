package com.seif.firstcomposeapp.ui.screens.repo_list.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.seif.firstcomposeapp.domain.usecase.FetchGithubReposUseCase

//class RepoListViewModelFactory(
//    private val fetchGithubReposUseCase: FetchGithubReposUseCase
//) : ViewModelProvider.Factory {
//
//    override fun <T : ViewModel> create(modelClass: Class<T>): T {
//        if (modelClass.isAssignableFrom(RepoListViewModel::class.java)) {
//            @Suppress("UNCHECKED_CAST")
//            return RepoListViewModel(fetchGithubReposUseCase) as T
//        }
//        throw IllegalArgumentException("Unknown ViewModel class: ${modelClass.name}")
//    }
//}
