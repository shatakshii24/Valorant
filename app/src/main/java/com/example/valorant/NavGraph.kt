package com.example.valorant

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument

@Composable
fun NavGraph(navController: NavHostController) {
    NavHost(navController = navController, startDestination = Screen.Splash.route) {
        composable(Screen.Splash.route) {
            SplashScreen(navController)
        }
        composable(Screen.Login.route) {
            LoginScreen(navController)
        }
        composable(Screen.Home.route) {
            HomeScreen(navController)
        }
        composable(Screen.Agents.route) {
            AgentListScreen(navController)
        }
        composable(
            route = Screen.AgentDetail.route,
            arguments = listOf(navArgument("uuid") { defaultValue = "" })
        ) { backStackEntry ->
            val agentId = backStackEntry.arguments?.getString("uuid") ?: ""
            AgentDetailScreen(uuid = agentId, navController = navController)
        }
    }
}
