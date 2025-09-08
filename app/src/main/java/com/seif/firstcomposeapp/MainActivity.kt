package com.seif.firstcomposeapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.seif.firstcomposeapp.screens.repo_details.RepoDetailsContent
import com.seif.firstcomposeapp.theme.FirstComposeAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            FirstComposeAppTheme {
                RepoDetailsContent()
            }
        }
    }
}
