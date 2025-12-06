package com.example.goodreadsapp.ui.navigation

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.goodreadsapp.data.network.RetrofitClient
import com.example.goodreadsapp.data.repository.BooksRepository
import com.example.goodreadsapp.ui.screens.home.HomeScreen
import com.example.goodreadsapp.ui.screens.SearchScreen
import com.example.goodreadsapp.ui.screens.MyBooksScreen
import com.example.goodreadsapp.ui.screens.home.HomeViewModel

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
            val api = RetrofitClient.create("a1b147d54cmsh764647262b789e5p1b9179jsn9ad671dc4933")
            val repo = BooksRepository(api)
            val homeVM = HomeViewModel(repo)

            composable(NavRoutes.Home.route) { HomeScreen(viewModel = homeVM,
                onBookClick = { id -> /* navigate later */ }) }
            composable(NavRoutes.Search.route) { SearchScreen(navController) }
            composable(NavRoutes.MyBooks.route) { MyBooksScreen(navController) }
        }
    }
}
