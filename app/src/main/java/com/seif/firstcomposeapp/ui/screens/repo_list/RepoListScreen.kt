package com.seif.firstcomposeapp.ui.screens.repo_list

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
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
    val viewmodel: RepoListViewModel = viewModel()

    val repoListState = remember {
        mutableStateOf<List<GithubReposUiModel>?>(null)
    }
    LaunchedEffect(Unit) {
        viewmodel.fetchGithubRepos()
    }
    repoListState.value?.let {
        RepoListContent(innerPadding, it, onRepoItemClicked)
    }
}

@Composable
fun RepoListContent(
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
        RepoListContent(PaddingValues(12.dp), fakeGithubReposUiModel) { _, _ -> }
    }
}