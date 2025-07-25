package com.example.valorant

import androidx.compose.runtime.Composable
import androidx.navigation.compose.rememberNavController

@Composable
fun ValorantApp() {
    val navController = rememberNavController()
    NavGraph(navController = navController)
}
