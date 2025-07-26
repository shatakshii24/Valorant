package com.example.valorant

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.*
import androidx.navigation.compose.rememberNavController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.example.valorant.ui.theme.ValorantTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            ValorantTheme {
                val navController = rememberNavController()
                var musicStarted by remember { mutableStateOf(false) }

                val currentEntry by navController.currentBackStackEntryAsState()
                val currentRoute = currentEntry?.destination?.route

                // 🎵 Start music after Splash screen only once
                LaunchedEffect(currentRoute) {
                    if (
                        currentRoute != null &&
                        currentRoute != Screen.Splash.route &&
                        !musicStarted
                    ) {
                        MusicPlayer.start(applicationContext)
                        musicStarted = true
                    }
                }

                Surface(color = MaterialTheme.colorScheme.background) {
                    NavGraph(navController = navController)
                }
            }
        }
    }
}
