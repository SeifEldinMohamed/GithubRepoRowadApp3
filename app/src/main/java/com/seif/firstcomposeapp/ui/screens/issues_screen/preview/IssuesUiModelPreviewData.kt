package com.example.githubreposapp.presentation.screens.issues_screen.preview


import com.seif.firstcomposeapp.ui.model.IssueState
import com.seif.firstcomposeapp.ui.screens.issues_screen.model.IssuesUiModel

val issuesUiModelPreviewData = IssuesUiModel(
    id = 12345,
    title = "Issue Title",
    author = "Seif",
    date = "Created At: 2023-01-01, 14:00 PM",
    state = IssueState.Open
)