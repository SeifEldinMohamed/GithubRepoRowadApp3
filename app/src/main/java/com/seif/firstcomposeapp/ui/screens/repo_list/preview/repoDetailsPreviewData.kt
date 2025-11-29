package com.seif.firstcomposeapp.ui.screens.repo_list.preview

import com.seif.firstcomposeapp.ui.screens.repo_list.model.GithubReposUiModel

val fakeGithubReposUiModel = listOf(
    GithubReposUiModel(
        id = 1,
        name = "Repo 1",
        avatar = "",
        description = "This is the description of repo 1",
        stars = 100,
        owner = "Owner 1"
    ),
    GithubReposUiModel(
        id = 2,
        name = "Repo 2",
        avatar = "",
        description = "This is the description of repo 2",
        stars = 200,
        owner = "Owner 2"
    ),
    GithubReposUiModel(
        id = 3,
        name = "Repo 3",
        avatar = "",
        description = "This is the description of repo 3",
        stars = 300,
        owner = "Owner 3"
    )
)
