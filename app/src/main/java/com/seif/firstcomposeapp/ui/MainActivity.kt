package com.seif.firstcomposeapp.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import com.seif.firstcomposeapp.R
import com.seif.firstcomposeapp.ui.common_components.MyAppBar
import com.seif.firstcomposeapp.ui.navigation.AppNavHost
import com.seif.firstcomposeapp.ui.theme.FirstComposeAppTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            FirstComposeAppTheme {
                Scaffold(
                    modifier = Modifier.fillMaxSize(),
                    topBar = {
                        MyAppBar(
                            title = R.string.repo_list_screen_title,
                            showBackButton = false
                        )
                    }
                ) { innerPadding ->
                    AppNavHost(innerPadding)
                }
            }
        }
    }
}

