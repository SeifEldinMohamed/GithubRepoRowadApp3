package com.seif.firstcomposeapp.ui.common_components

import androidx.annotation.StringRes
import androidx.compose.foundation.background
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.seif.firstcomposeapp.R
import com.seif.firstcomposeapp.ui.theme.FirstComposeAppTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MyAppBar(
    @StringRes title: Int,
    modifier: Modifier = Modifier,
    showBackButton: Boolean = true,
    backgroundColor: Color = MaterialTheme.colorScheme.primary,
    onBackButtonClicked:() -> Unit = {}
) {
    CenterAlignedTopAppBar(
        modifier = modifier.background(backgroundColor),
        title = {
            Text(text = stringResource(title))
        },
        navigationIcon = {
            IconButton(
                onClick = {
                    onBackButtonClicked()
                }
            ) {
                if (showBackButton)
                    Icon(
                        imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                        contentDescription = null
                    )
            }
        }
    )
}

@Preview
@Composable
private fun PreviewMyAppBar() {
    FirstComposeAppTheme {
        MyAppBar(
            title = R.string.app_name
        ){

        }
    }
}
