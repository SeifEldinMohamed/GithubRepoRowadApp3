package com.seif.firstcomposeapp.ui.screens.repo_list.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.seif.firstcomposeapp.R

@Composable
fun RepoItem(
    modifier: Modifier = Modifier,
    onRepoItemClicked: () -> Unit
) {

    Row (
        modifier.fillMaxWidth()
            .padding(horizontal = 8.dp)
            .padding(top = 8.dp)
            .background(
                color = MaterialTheme.colorScheme.surface,
                shape = MaterialTheme.shapes.medium
            )
            .clickable {
                onRepoItemClicked()
            },
    ) {
        Image(
            modifier = Modifier.size(50.dp)
                .padding(top = 8.dp, start = 8.dp)
                .clip(CircleShape),
            painter = painterResource(R.drawable.ic_launcher_background),
            contentDescription = null
        )

        Column(modifier = Modifier.padding(8.dp)) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
                ) {
            }
        }
    }
}
