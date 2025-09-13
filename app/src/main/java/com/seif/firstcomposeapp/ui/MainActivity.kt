package com.seif.firstcomposeapp.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.Scaffold
import com.seif.firstcomposeapp.R
import com.seif.firstcomposeapp.ui.common_components.MyAppBar
import com.seif.firstcomposeapp.ui.navigation.AppNavHost
import com.seif.firstcomposeapp.ui.theme.FirstComposeAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            FirstComposeAppTheme {
                Scaffold(
                    topBar = {
                        MyAppBar(
                            title = R.string.repo_details_screen_title,
                            onBackButtonClicked = {

                            }
                        )
                    }
                ) { innerPadding ->
                    AppNavHost(innerPadding)
                }
            }
        }
    }
}
