package com.seif.firstcomposeapp.ui.screens.repo_details

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.seif.firstcomposeapp.R
import com.seif.firstcomposeapp.ui.screens.repo_details.components.RepoDetailsItem
import com.seif.firstcomposeapp.ui.theme.FirstComposeAppTheme

@Composable
fun RepoDetailsScreen(innerPadding: PaddingValues) {
    RepoDetailsContent(innerPadding)
}

@Composable
fun RepoDetailsContent(
    innerPadding: PaddingValues
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(innerPadding)
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painter = painterResource(R.drawable.ic_launcher_foreground),
            contentDescription = null,
            modifier = Modifier
                .size(150.dp)
                .clip(CircleShape)
        )

        Text(
            text = "Google",
            style = MaterialTheme.typography.headlineSmall,
            maxLines = 1,
            overflow = TextOverflow.Ellipsis
        )

        Row(
            modifier = Modifier.padding(top = 12.dp)
        ) {
            RepoDetailsItem(
                "12312",
                R.drawable.ic_star
            )
            Spacer(modifier = Modifier.width(16.dp))
            Row {
                Text(text = "Python", style = MaterialTheme.typography.bodySmall)
                Box(
                    modifier = Modifier
                        .padding(start = 4.dp)
                        .size(20.dp)
                        .clip(CircleShape)
                        .background(MaterialTheme.colorScheme.secondary)
                )
            }
            Spacer(modifier = Modifier.width(16.dp))
            RepoDetailsItem(
                "31234",
                R.drawable.ic_fork
            )
        }

        Text(
            text = "Description",
            style = MaterialTheme.typography.bodyMedium
        )

        Spacer(modifier = Modifier.weight(1f))

        Button(onClick = {}, colors = ButtonDefaults.buttonColors(
            containerColor = MaterialTheme.colorScheme.secondary
        )) {
            Text(
                text = "Show Issues",
                style = MaterialTheme.typography.titleMedium.copy(color = MaterialTheme.colorScheme.onSecondary),
            )
        }
    }
}

@Preview(
    showBackground = true,
    showSystemUi = true,
)
@Composable
fun PreviewRepoDetailsContent() {
    FirstComposeAppTheme {
        RepoDetailsContent(
            innerPadding = PaddingValues(0.dp)
        )
    }
}
