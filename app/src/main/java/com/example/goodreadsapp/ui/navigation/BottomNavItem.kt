package com.example.goodreadsapp.ui.navigation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Bookmark
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Search
import androidx.compose.ui.graphics.vector.ImageVector

data class BottomNavItem(
    val label: String,
    val icon: ImageVector,
    val route: String
)

val bottomNavItems = listOf(
    BottomNavItem("Home", Icons.Default.Home, NavRoutes.Home.route),
    BottomNavItem("Search", Icons.Default.Search, NavRoutes.Search.route),
    BottomNavItem("My Books", Icons.Default.Bookmark, NavRoutes.MyBooks.route)
)
