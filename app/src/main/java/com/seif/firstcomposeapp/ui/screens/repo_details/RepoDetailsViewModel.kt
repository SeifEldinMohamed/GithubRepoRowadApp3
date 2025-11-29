package com.seif.firstcomposeapp.ui.screens.repo_details

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.seif.firstcomposeapp.domain.usecase.FetchGithubReposDetailsUseCase
import com.seif.firstcomposeapp.ui.screens.repo_list.mapper.toRepoDetailsUiModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class RepoDetailsViewModel @Inject constructor(
    private val fetchGithubReposDetailsUseCase: FetchGithubReposDetailsUseCase
): ViewModel() {
    private val _repoDetailsStateFlow: MutableStateFlow<RepoDetailsUiState> = MutableStateFlow(
        RepoDetailsUiState()
    )
    val repoDetailsStateFlow: StateFlow<RepoDetailsUiState> = _repoDetailsStateFlow.asStateFlow()

    fun requestRepoDetails(
        ownerName:String,
        repoName:String
    ){
        _repoDetailsStateFlow.value = _repoDetailsStateFlow.value.copy(isLoading = true)
        viewModelScope.launch(Dispatchers.IO) {
            try {
               val repoDetailsDomainModel = fetchGithubReposDetailsUseCase.invoke(ownerName, repoName)
                _repoDetailsStateFlow.value = _repoDetailsStateFlow.value.copy(
                    isLoading = false,
                    repoDetailsUiModel = repoDetailsDomainModel.toRepoDetailsUiModel()
                )
            } catch (e:Exception) {
                _repoDetailsStateFlow.value = _repoDetailsStateFlow.value.copy(
                    isLoading = false,
                    isError = true,
                    errorMessage = e.message.toString()
                )
            }
        }
    }
}