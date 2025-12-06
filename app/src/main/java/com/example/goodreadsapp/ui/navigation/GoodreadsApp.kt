package com.example.goodreadsapp.ui.navigation

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.goodreadsapp.ui.screens.HomeScreen
import com.example.goodreadsapp.ui.screens.SearchScreen
import com.example.goodreadsapp.ui.screens.MyBooksScreen

@Composable
fun GoodreadsApp() {
    val navController = rememberNavController()

    Scaffold(
        bottomBar = {
            BottomNavBar(navController)
        }
    ) { innerPadding ->
        NavHost(
            navController = navController,
            startDestination = NavRoutes.Home.route,
            modifier = Modifier.padding(innerPadding)
        ) {
            composable(NavRoutes.Home.route) { HomeScreen(navController) }
            composable(NavRoutes.Search.route) { SearchScreen(navController) }
            composable(NavRoutes.MyBooks.route) { MyBooksScreen(navController) }
        }
    }
}
