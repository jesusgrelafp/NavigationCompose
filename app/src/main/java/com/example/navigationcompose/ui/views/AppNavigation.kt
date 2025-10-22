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
        composable(route = "home") {
            HomeScreen(
                products = uiState.products,
                total = uiState.cartItems.sumOf { it.price * it.quantity },
                onNavigateToDetail = {id -> navController.navigate("detalle/$id")},
                onNavigateToCart = {navController.navigate("cart")}
            )
        }
        composable(route = "detalle/{id}",
                    arguments = listOf(navArgument("id") {type = NavType.IntType})
        ) { backStackEntry ->
               val id = backStackEntry.arguments?.getInt("id") ?: 0
               val product = viewModel.getProductById(id)
               DetailScreenAdvanced(
                   product = product,
                   onBack = {navController.popBackStack()},
                   onAddToCart = { product, quantity -> viewModel.addToCart(product,quantity)
                                   navController.popBackStack()
                                 }
               )
        }
        composable(route = "cart") {
            CartScreen(
                cartItems = uiState.cartItems,
                onBack = {navController.popBackStack()},
                onRemoveFromCart = {id -> viewModel.removeFromCart(id)}
            )
        }
    }
}