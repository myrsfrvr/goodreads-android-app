package com.example.goodreadsapp.ui.navigation

sealed class NavRoutes(val route: String) {
    object Home : NavRoutes("home")
    object Search : NavRoutes("search")
    object Genre : NavRoutes("genre/{genre}") {
        fun createRoute(genre: String) = "genre/$genre"
    }
    object MyBooks : NavRoutes("mybooks")

    object BookDetail : NavRoutes("books/{bookId}") {
        fun createRoute(bookId: Long) = "books/$bookId"
    }


}
