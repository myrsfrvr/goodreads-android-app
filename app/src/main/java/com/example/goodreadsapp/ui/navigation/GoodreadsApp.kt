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
import com.example.goodreadsapp.ui.screens.search.SearchScreen
import com.example.goodreadsapp.ui.screens.MyBooksScreen
import com.example.goodreadsapp.ui.screens.home.HomeViewModel
import com.example.goodreadsapp.ui.screens.search.GenreScreen
import com.example.goodreadsapp.ui.screens.search.SearchViewModel

@Composable
fun GoodreadsApp() {
    val navController = rememberNavController()

    Scaffold(
        bottomBar = {
            BottomNavBar(navController)
        }
    ) { innerPadding ->
        AppNavHost(
            navController = navController,
            modifier = Modifier.padding(innerPadding)
        )
    }
}
