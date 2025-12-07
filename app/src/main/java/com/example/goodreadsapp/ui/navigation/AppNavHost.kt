package com.example.goodreadsapp.ui.navigation

import BookDetailViewModelFactory
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.goodreadsapp.data.network.GoodreadsDetailsRetrofitClient
import com.example.goodreadsapp.data.network.RetrofitClient
import com.example.goodreadsapp.data.repository.BookDetailRepository
import com.example.goodreadsapp.data.repository.BooksRepository
import com.example.goodreadsapp.ui.screens.BookListScreen
import com.example.goodreadsapp.ui.screens.home.HomeScreen
import com.example.goodreadsapp.ui.screens.search.SearchScreen
import com.example.goodreadsapp.ui.screens.MyBooksScreen
import com.example.goodreadsapp.ui.screens.MyBooksViewModel
import com.example.goodreadsapp.ui.screens.detail.BookDetailScreen
import com.example.goodreadsapp.ui.screens.detail.BookDetailViewModel
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
        val myBooksVM = MyBooksViewModel()

        composable(NavRoutes.Home.route) {
            HomeScreen(
                viewModel = homeVM,
                onBookClick = { id ->
                    navController.navigate(NavRoutes.BookDetail.createRoute(id))
                })
        }
        composable(NavRoutes.Search.route) {
            SearchScreen(
                viewModel = searchVM,
                onBookClick = { id ->
                    navController.navigate(NavRoutes.BookDetail.createRoute(id))
                },
                onGenreClick = { genre ->
                    navController.navigate(NavRoutes.Genre.createRoute(genre))
                }
            )
        }
        composable(NavRoutes.Genre.route) { backStack ->
            val genre = backStack.arguments?.getString("genre") ?: ""
            GenreScreen(
                genre = genre,
                viewModel = searchVM,
                onBookClick = { bookId ->
                    navController.navigate(NavRoutes.BookDetail.createRoute(bookId))
                }
            )
        }
        composable(NavRoutes.MyBooks.route) {
            MyBooksScreen(navController, viewModel = myBooksVM)
        }
        composable("mybooks/list/{listType}") { backStack ->
            val listType = backStack.arguments?.getString("listType") ?: "Reading"
            BookListScreen(
                listType = listType,
                navController = navController,
                viewModel = myBooksVM,
                onBookClick = { bookId ->
                    navController.navigate(NavRoutes.BookDetail.createRoute(bookId))
                }
            )

        }
        composable(NavRoutes.BookDetail.route) { backStack ->
            val bookIdString = backStack.arguments?.getString("bookId")

            if (bookIdString != null) {
                val bookId = bookIdString.toLongOrNull()
                if (bookId != null && bookId != 0L) {
                    val api =
                        GoodreadsDetailsRetrofitClient.create("a1b147d54cmsh764647262b789e5p1b9179jsn9ad671dc4933")
                    val repo = BookDetailRepository(api)
//                    val viewModel = BookDetailViewModel(repo)
                    val factory = BookDetailViewModelFactory(repo)
                    val viewModel: BookDetailViewModel = androidx.lifecycle.viewmodel.compose.viewModel(factory = factory)

                    BookDetailScreen(
                        navController = navController,
                        bookId = bookId,
                        viewModel = viewModel
                    )
                } else {
                    Text("Invalid book ID")
                }
            } else {
                Text("Book ID missing")
            }
        }
    }
}
