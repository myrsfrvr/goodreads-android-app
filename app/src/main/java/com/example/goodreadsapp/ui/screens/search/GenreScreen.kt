package com.example.goodreadsapp.ui.screens.search

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.clickable
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.example.goodreadsapp.data.model.BookDto


@Composable
fun GenreScreen(
    genre: String,
    viewModel: SearchViewModel,
    onBookClick: (Long) -> Unit
) {
    val books by viewModel.genreBooks.collectAsState()

    LaunchedEffect(genre) {
        viewModel.loadGenreBooks(genre)
    }

    Column(Modifier.fillMaxSize().padding(16.dp)) {
        Text("Best books in ${genre.replaceFirstChar { it.uppercase() }}")

        Spacer(Modifier.height(16.dp))

        LazyVerticalGrid(
            columns = GridCells.Fixed(2),
            verticalArrangement = Arrangement.spacedBy(16.dp),
            horizontalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            items(books) { book ->
                val cleanTitle = remember(book.title) {
                    book.title.replace(Regex("\\s*\\(.*?\\)"), "")
                }

                Column(Modifier.clickable { onBookClick(book.id) }) {
                    AsyncImage(
                        model = book.smallImageURL,
                        contentDescription = null,
                        modifier = Modifier.height(160.dp).fillMaxWidth()
                    )
                    Text(
                        text = cleanTitle,
                        fontSize = 20.sp,
                        fontWeight = FontWeight.Bold,
                        color = MaterialTheme.colorScheme.onSurface,
                        modifier = Modifier.padding(top = 4.dp)
                    )
                    Text(
                        text = book.author,
                        fontSize = 16.sp,
                        color = MaterialTheme.colorScheme.onSurfaceVariant
                    )
                }
            }
        }
    }
}
