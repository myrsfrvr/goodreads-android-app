package com.example.goodreadsapp.ui.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.goodreadsapp.data.network.RetrofitClient
import com.example.goodreadsapp.data.repository.BooksRepository
import com.example.goodreadsapp.ui.screens.home.HomeScreen
import com.example.goodreadsapp.ui.screens.search.SearchScreen
import com.example.goodreadsapp.ui.screens.MyBooksScreen
import com.example.goodreadsapp.ui.screens.BookDetailScreen
import com.example.goodreadsapp.ui.screens.home.HomeViewModel
import com.example.goodreadsapp.ui.screens.search.GenreScreen
import com.example.goodreadsapp.ui.screens.search.SearchViewModel

@Composable
fun AppNavHost(navController: NavHostController, modifier: Modifier = Modifier) {
    NavHost(
        navController = navController,
        startDestination = NavRoutes.Home.route,
        modifier = modifier
    ) {
        val api = RetrofitClient.create("a1b147d54cmsh764647262b789e5p1b9179jsn9ad671dc4933")
        val repo = BooksRepository(api)
        val homeVM = HomeViewModel(repo)
        val searchVM = SearchViewModel(repo)

        composable(NavRoutes.Home.route) { HomeScreen(viewModel = homeVM,
            onBookClick = { id -> /* navigate later */ }) }
        composable(NavRoutes.Search.route) { SearchScreen(viewModel= searchVM,
            onBookClick= { id -> /* navigate later */ },
            onGenreClick= { genre ->
                navController.navigate(NavRoutes.Genre.createRoute(genre)) }
            ) }
        composable(NavRoutes.Genre.route) { backStack ->
            val genre = backStack.arguments?.getString("genre") ?: ""
            GenreScreen(
                genre = genre,
                viewModel = searchVM,
                onBookClick = {}
            )
        }
        composable(NavRoutes.MyBooks.route) { MyBooksScreen(navController) }
        composable(NavRoutes.BookDetail.route) { backStack ->
            val id = backStack.arguments?.getString("bookId") ?: ""
            BookDetailScreen(navController, id)
        }
    }
}
