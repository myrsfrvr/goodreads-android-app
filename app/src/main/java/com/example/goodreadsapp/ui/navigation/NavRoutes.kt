package com.example.goodreadsapp.ui.navigation

sealed class NavRoutes(val route: String) {
    object Home : NavRoutes("home")
    object Search : NavRoutes("search")
    object MyBooks : NavRoutes("mybooks")
    object BookDetail : NavRoutes("book_detail/{bookId}") {
        fun createRoute(bookId: String) = "book_detail/$bookId"
    }
}
