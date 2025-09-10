package com.seif.firstcomposeapp.ui.screens.repo_details.components

import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.seif.firstcomposeapp.R
import com.seif.firstcomposeapp.ui.theme.FirstComposeAppTheme

@Composable
fun RepoDetailsItem(title: String, @DrawableRes icon: Int) {
    Row {
        Text(
            text = title,
            style = MaterialTheme.typography.bodyLarge,
            modifier = Modifier.padding(end = 4.dp)
        )

        Image(
            painter = painterResource(icon),
            contentDescription = null
        )
    }
}

@Preview
@Composable
private fun PreviewRepoDetailsItem() {
    FirstComposeAppTheme {
        RepoDetailsItem("test", R.drawable.ic_fork)
    }
}
