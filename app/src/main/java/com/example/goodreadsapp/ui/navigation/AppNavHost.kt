package com.example.goodreadsapp.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.goodreadsapp.ui.screens.HomeScreen
import com.example.goodreadsapp.ui.screens.SearchScreen
import com.example.goodreadsapp.ui.screens.MyBooksScreen
import com.example.goodreadsapp.ui.screens.BookDetailScreen

@Composable
fun AppNavHost(navController: NavHostController) {
    NavHost(
        navController = navController,
        startDestination = NavRoutes.Home.route
    ) {
        composable(NavRoutes.Home.route) { HomeScreen(navController) }
        composable(NavRoutes.Search.route) { SearchScreen(navController) }
        composable(NavRoutes.MyBooks.route) { MyBooksScreen(navController) }
        composable(NavRoutes.BookDetail.route) { backStack ->
            val id = backStack.arguments?.getString("bookId") ?: ""
            BookDetailScreen(navController, id)
        }
    }
}
