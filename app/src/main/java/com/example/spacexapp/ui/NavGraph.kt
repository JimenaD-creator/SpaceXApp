package com.example.spacexapp.ui

import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.spacexapp.ui.detail.DetailScreen
import com.example.spacexapp.ui.launches.LaunchesScreen

@Composable
fun SpaceXNavGraph(
    navController: NavHostController = rememberNavController()
) {
    NavHost(
        navController = navController,
        // First screen shown
        startDestination = "launches"
    ){
        // Route for list screen
        composable("launches") {
            LaunchesScreen(
                onLaunchClick = { launchId ->
                    // Navigate to a route
                    navController.navigate("detail/$launchId")
                }
            )
        }
        //Dynamic route with parameter
        composable("detail/{launchId}") { backStackEntry ->
            val launchId = backStackEntry.arguments?.getString("launchId") ?: ""
            DetailScreen(
                launchId = launchId,
                onBackClick = { navController.popBackStack() }
            )
        }
    }
}