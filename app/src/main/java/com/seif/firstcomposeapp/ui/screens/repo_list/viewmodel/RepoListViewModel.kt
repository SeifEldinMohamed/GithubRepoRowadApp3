package com.seif.firstcomposeapp.ui.screens.repo_list.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.seif.firstcomposeapp.domain.usecase.FetchGithubReposUseCase
import com.seif.firstcomposeapp.ui.screens.repo_list.RepoListUiState
import com.seif.firstcomposeapp.ui.screens.repo_list.mapper.toGithubRepoListUiModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class RepoListViewModel @Inject constructor(
    private val fetchGithubReposUseCase: FetchGithubReposUseCase
) : ViewModel() {
    private val _repoListStateFlow = MutableStateFlow<RepoListUiState>(RepoListUiState.InitialState)
    val repoListStateFlow: StateFlow<RepoListUiState> = _repoListStateFlow.asStateFlow()

    fun requestGithubRepoList(){
        _repoListStateFlow.value = RepoListUiState.Loading(isLoading = true)
        viewModelScope.launch(Dispatchers.IO) {
            try {
                val repoListDomainModel = fetchGithubReposUseCase.invoke()
                _repoListStateFlow.value = RepoListUiState.Loading(isLoading = false)
                _repoListStateFlow.value = RepoListUiState.RepoList(
                    repoList = repoListDomainModel.toGithubRepoListUiModel()
                )
            }catch (e:Exception){
                _repoListStateFlow.value = RepoListUiState.Loading(isLoading = false)
                _repoListStateFlow.value = RepoListUiState.Error(message = e.message.toString())
            }
        }
    }
}

// screen -> viewmodel -> usecase -> repository -> remoteDataSource -> Api