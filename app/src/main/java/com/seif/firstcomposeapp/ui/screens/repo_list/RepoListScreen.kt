package com.seif.firstcomposeapp.ui.screens.repo_list

import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.seif.firstcomposeapp.ui.screens.repo_list.components.RepoItem
import com.seif.firstcomposeapp.ui.screens.repo_list.model.GithubReposUiModel
import com.seif.firstcomposeapp.ui.screens.repo_list.preview.fakeGithubReposUiModel
import com.seif.firstcomposeapp.ui.screens.repo_list.viewmodel.RepoListViewModel
import com.seif.firstcomposeapp.ui.theme.FirstComposeAppTheme

@Composable
fun RepoListScreen(
    innerPadding: PaddingValues,
    onRepoItemClicked: (owner: String, name: String) -> Unit,
) {

    val repoListViewModel: RepoListViewModel = hiltViewModel()

    LaunchedEffect(Unit) {
        repoListViewModel.requestGithubRepoList()
    }

    val repoListUiSate by repoListViewModel.repoListStateFlow.collectAsStateWithLifecycle()

    RepoListContent(innerPadding, repoListUiSate, onRepoItemClicked)

}

@Composable
fun RepoListContent(
    innerPadding: PaddingValues,
    repoListUiState: RepoListUiState,
    onRepoItemClicked: (owner: String, name: String) -> Unit,
) {
    when (repoListUiState) {
        RepoListUiState.InitialState -> {}
        is RepoListUiState.Loading -> {
            if (repoListUiState.isLoading){
                Box(Modifier.fillMaxSize()) {
                    CircularProgressIndicator(modifier = Modifier.align(Alignment.Center))
                }
            }
        }

        is RepoListUiState.RepoList -> {
            RepoListLazyColumn(
                innerPadding,
                repoListUiState.repoList,
                onRepoItemClicked
            )
        }

        is RepoListUiState.Error -> {
            Toast.makeText(LocalContext.current, "Error: ${repoListUiState.message}", Toast.LENGTH_SHORT).show()
        }
    }

}

@Composable
fun RepoListLazyColumn(
    innerPadding: PaddingValues,
    repoList: List<GithubReposUiModel>,
    onRepoItemClicked: (owner: String, name: String) -> Unit,
) {
    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background)
            .padding(innerPadding)
    ) {
        items(repoList) { repoUiModelItem ->
            RepoItem(repoUiModelItem) { owner, name ->
                onRepoItemClicked(owner, name)
            }
        }
    }
}


@Preview
@Composable
private fun PreviewRepoListContent() {
    FirstComposeAppTheme {
        RepoListContent(PaddingValues(12.dp), RepoListUiState.RepoList(fakeGithubReposUiModel)) { _, _ -> }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
private fun PreviewRepoListContentLoading() {
    FirstComposeAppTheme {
        RepoListContent(PaddingValues(12.dp), RepoListUiState.Loading(isLoading = true)) { _, _ -> }
    }
}

// create application class then add annotation & add it to manifest
// create di package & create modules inside it