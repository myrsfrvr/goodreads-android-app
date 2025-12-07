package com.example.goodreadsapp.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.example.goodreadsapp.R
import com.example.goodreadsapp.ui.screens.search.BooksGrid

@Composable
fun BookListScreen(
    listType: String,
    navController: NavController,
    viewModel: MyBooksViewModel = viewModel(),
    onBookClick: (Long) -> Unit
) {
    val books = when (listType) {
        "Reading" -> viewModel.readingBooks
        "WantToRead" -> viewModel.wantToReadBooks
        "Read" -> viewModel.readBooks
        else -> emptyList()
    }

    Column(modifier = Modifier.fillMaxSize()) {

        // TOP BAR
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(56.dp)
                .background(Color(0xFFE4E2D5)),
        ) {
            Icon(
                imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                contentDescription = "Back",
                modifier = Modifier
                    .align(Alignment.CenterStart)
                    .padding(start = 16.dp)
                    .clickable { navController.popBackStack() }
            )

            Image(
                painter = painterResource(R.drawable.home_logo),
                contentDescription = null,
                modifier = Modifier
                    .height(40.dp)
                    .align(Alignment.Center)
            )
        }

        Spacer(modifier = Modifier.height(16.dp))

        Text(
            "$listType Books",
            style = MaterialTheme.typography.titleLarge,
            modifier = Modifier.padding(horizontal = 16.dp)
        )

        Spacer(modifier = Modifier.height(16.dp))

        BooksGrid(books = books, onBookClick = onBookClick)
    }
}
