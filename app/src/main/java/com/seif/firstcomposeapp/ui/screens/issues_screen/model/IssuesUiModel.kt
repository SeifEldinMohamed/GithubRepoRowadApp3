package com.seif.firstcomposeapp.ui.screens.issues_screen.model

import com.seif.firstcomposeapp.ui.model.IssueState


data class IssuesUiModel(
    val id:Int,
    val title: String,
    val author: String,
    val date: String,
    val state: IssueState,
)