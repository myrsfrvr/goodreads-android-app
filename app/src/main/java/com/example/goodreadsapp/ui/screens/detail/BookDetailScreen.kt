package com.example.goodreadsapp.ui.screens.detail

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.Star
//import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import coil.compose.AsyncImage
import com.example.goodreadsapp.ui.screens.detail.BookDetailViewModel

@Composable
fun BookDetailScreen(
    navController: NavHostController,
    bookId: Long,
    viewModel: BookDetailViewModel
) {
    LaunchedEffect(bookId) {
        viewModel.loadBook(bookId)
    }

    val book by viewModel.book.collectAsState()

    if (book == null) {
        Box(
            Modifier.fillMaxSize(),
            contentAlignment = Alignment.Center
        ) {
            Text("Loading book details...")
        }
    } else {
        val b = book!!

    Column(Modifier.fillMaxSize()) {
        // Top Bar
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .background(Color(0xFFFFF4E6))
                .padding(12.dp)
        ) {
            Icon(
                imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                contentDescription = "Back",
                modifier = Modifier
                    .clickable { navController.popBackStack() }
            )
        }

        book?.let { b ->
            Column(Modifier.padding(16.dp)) {

                // Row: Image + title/author
                Row(Modifier.fillMaxWidth()) {
                    AsyncImage(
                        model = b.imageUrl,
                        contentDescription = null,
                        modifier = Modifier
                            .width(120.dp)
                            .height(180.dp)
                    )
                    Spacer(Modifier.width(16.dp))
                    Column(
                        verticalArrangement = Arrangement.Center
                    ) {
                        Text(text = b.title, style = MaterialTheme.typography.titleLarge)
                        Text(text = b.author.name, style = MaterialTheme.typography.titleMedium)
                    }
                }

                Spacer(Modifier.height(16.dp))

                // Rating
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Text(text = "Average rating: ${b.stats.averageRating}")
                    Spacer(Modifier.width(4.dp))
                    Icon(
                        imageVector = Icons.Filled.Star,
                        contentDescription = null,
                        tint = Color.Yellow
                    )
                }

                Spacer(Modifier.height(16.dp))

                // Description
                Text(text = b.description, style = MaterialTheme.typography.bodyMedium)

                Spacer(Modifier.height(16.dp))

                Text("Genres", style = MaterialTheme.typography.titleMedium)
                Spacer(Modifier.height(8.dp))

                LazyVerticalGrid(
                    columns = GridCells.Fixed(2),
                    verticalArrangement = Arrangement.spacedBy(8.dp),
                    horizontalArrangement = Arrangement.spacedBy(8.dp),
                    modifier = Modifier.heightIn(max = 200.dp)
                ) {
                    items(b.bookGenres) { genre ->
                        Box(
                            modifier = Modifier
                                .background(Color.LightGray)
                                .padding(8.dp)
                        ) {
                            Text(genre.name)
                        }
                    }
                }
            }
        }
    }

    }
}