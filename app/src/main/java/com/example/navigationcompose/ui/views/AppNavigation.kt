package com.example.navigationcompose.ui.views

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.navigationcompose.viewmodel.ProductViewModel

@Composable
fun AppNavigation(viewModel: ProductViewModel = viewModel()) {

    val navController: NavHostController = rememberNavController()
    NavHost(navController, startDestination = "home") {
        composable("home") {
            HomeScreen(navController, viewModel)
        }
        composable("detalle/{id}",
                    arguments = listOf(navArgument("id") {type = NavType.IntType})
        ) { backStackEntry ->
               val id = backStackEntry.arguments?.getInt("id") ?: 0
               DetailScreenAdvanced(id = id, navController = navController, viewModel)
        }

    }

}