package com.seif.firstcomposeapp.ui.screens.repo_details

import android.widget.Toast
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
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import coil.compose.rememberAsyncImagePainter
import coil.request.ImageRequest
import com.example.githubreposappdepiround2.ui.common_components.shimmer.details.AnimateShimmerDetails
import com.seif.firstcomposeapp.R
import com.seif.firstcomposeapp.ui.screens.repo_details.components.RepoDetailsItem
import com.seif.firstcomposeapp.ui.screens.repo_details.preview.fakeRepoDetailsUiModel
import com.seif.firstcomposeapp.ui.screens.repo_list.model.RepoDetailsUiModel
import com.seif.firstcomposeapp.ui.theme.FirstComposeAppTheme

@Composable
fun RepoDetailsScreen(
    innerPadding: PaddingValues,
    ownerName:String,
    repoName:String
) {
    val repoDetailsViewModel: RepoDetailsViewModel = hiltViewModel()
    LaunchedEffect(Unit) {
        repoDetailsViewModel.requestRepoDetails(ownerName, repoName)
    }
    val repoDetailsUiState by repoDetailsViewModel.repoDetailsStateFlow.collectAsStateWithLifecycle()
    when {
        repoDetailsUiState.isLoading -> {
            AnimateShimmerDetails()
        }
        repoDetailsUiState.isError -> {
            Toast.makeText(LocalContext.current, "Error: ${repoDetailsUiState.errorMessage}", Toast.LENGTH_SHORT).show()
        }
        else -> {
            repoDetailsUiState.repoDetailsUiModel?.let { repoDetailsUiModel ->
                RepoDetailsContent(
                    innerPadding,
                    repoDetailsUiModel
                )
            }
        }
    }
}

@Composable
fun RepoDetailsContent(
    innerPadding: PaddingValues,
    repoDetailsUiModel: RepoDetailsUiModel
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(innerPadding)
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painter = rememberAsyncImagePainter(
                ImageRequest.Builder(LocalContext.current)
                    .data(data = repoDetailsUiModel.avatar)
                    .build()
            ),
            contentDescription = null,
            modifier = Modifier
                .size(150.dp)
                .clip(CircleShape)
        )

        Text(
            text = repoDetailsUiModel.name,
            style = MaterialTheme.typography.headlineSmall,
            maxLines = 1,
            overflow = TextOverflow.Ellipsis
        )

        Row(
            modifier = Modifier.padding(top = 12.dp)
        ) {
            RepoDetailsItem(
                repoDetailsUiModel.starsCount,
                R.drawable.ic_star
            )
            Spacer(modifier = Modifier.width(16.dp))
            Row {
                Text(text = repoDetailsUiModel.language, style = MaterialTheme.typography.bodySmall)
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
                repoDetailsUiModel.forksCount,
                R.drawable.ic_fork
            )
        }

        Text(
            text = repoDetailsUiModel.description,
            style = MaterialTheme.typography.bodyMedium
        )

        Spacer(modifier = Modifier.weight(1f))

        Button(onClick = {}, colors = ButtonDefaults.buttonColors(
            containerColor = MaterialTheme.colorScheme.secondary
        )) {
            Text(
                text = stringResource(R.string.show_issues),
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
            innerPadding = PaddingValues(0.dp),
            repoDetailsUiModel = fakeRepoDetailsUiModel
        )
    }
}
