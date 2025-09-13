package com.seif.firstcomposeapp.ui.screens.repo_list

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.seif.firstcomposeapp.ui.screens.repo_list.components.RepoItem
import com.seif.firstcomposeapp.ui.screens.repo_list.model.RepoUiModel

@Composable
fun RepoListScreen(
    innerPadding:PaddingValues,
    onRepoItemClicked: (owner:String, name:String) -> Unit
) {
    LazyColumn(
        modifier = Modifier.fillMaxSize()
            .background(MaterialTheme.colorScheme.background)
            .padding(innerPadding)
    ) {
        items(fakeRepoItems()){ repoUiModelItem ->
            RepoItem(repoUiModelItem){ owner, name ->
                onRepoItemClicked(owner, name)
            }
        }
    }
}

private fun fakeRepoItems(): List<RepoUiModel> {
        return listOf(
            RepoUiModel(
                id = 1,
                name = "Repo 1",
                avatar = "",
                description = "This is the description of repo 1",
                stars = 100,
                owner = "Owner 1"
            ),
            RepoUiModel(
                id = 2,
                name = "Repo 2",
                avatar = "",
                description = "This is the description of repo 2",
                stars = 200,
                owner = "Owner 2"
            ),
            RepoUiModel(
                id = 3,
                name = "Repo 3",
                avatar = "",
                description = "This is the description of repo 3",
                stars = 300,
                owner = "Owner 3"
            )
        )
}
