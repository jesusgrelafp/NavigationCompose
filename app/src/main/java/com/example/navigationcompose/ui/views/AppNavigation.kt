package com.example.navigationcompose.ui.views

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.navigationcompose.viewmodel.ProductViewModel

@Composable
fun AppNavigation(viewModel: ProductViewModel = viewModel()) {

    val uiState by viewModel.uiState.collectAsState()
    val navController: NavHostController = rememberNavController()
    NavHost(navController, startDestination = "home") {
        composable("home") {
            HomeScreen(products = uiState.products,
                       onNavigateToDetail = {id -> navController.navigate("detalle/$id")} )
        }
        composable("detalle/{id}",
                    arguments = listOf(navArgument("id") {type = NavType.IntType})
        ) { backStackEntry ->
               val id = backStackEntry.arguments?.getInt("id") ?: 0
               val product = viewModel.getProductById(id)
               DetailScreenAdvanced(onBack = {navController.popBackStack()},
                                    product = product)
        }
    }
}