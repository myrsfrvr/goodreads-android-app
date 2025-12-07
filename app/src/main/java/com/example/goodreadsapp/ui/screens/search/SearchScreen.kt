package com.example.goodreadsapp.ui.screens.search

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.example.goodreadsapp.data.model.BookDto

@Composable
fun SearchScreen(
    viewModel: SearchViewModel,
    onBookClick: (Long) -> Unit,
    onGenreClick: (String) -> Unit
) {
    val searchQuery by viewModel.searchQuery.collectAsState()
    val searchResults by viewModel.searchResults.collectAsState()

    Column(modifier = Modifier.fillMaxSize().padding(16.dp)) {

        // SEARCH BAR
        OutlinedTextField(
            value = searchQuery,
            onValueChange = { viewModel.updateQuery(it) },
            modifier = Modifier.fillMaxWidth(),
            placeholder = { Text("Search books...") }
        )

        Spacer(Modifier.height(16.dp))

        // SHOW SEARCH RESULTS IF QUERY NOT EMPTY
        if (searchQuery.isNotBlank()) {
            BooksGrid(books = searchResults, onBookClick)
            return@Column
        }

        // EXPLORE GENRES
        Text(
            "Explore popular genres",
            style = MaterialTheme.typography.titleMedium,
            modifier = Modifier.padding(vertical = 8.dp)
        )

        GenreGrid(
            genres = listOf("fantasy", "romance", "history", "science", "thriller", "poetry"),
            onGenreClick = onGenreClick
        )
    }
}

@Composable
fun GenreGrid(genres: List<String>, onGenreClick: (String) -> Unit) {
    LazyVerticalGrid(
        columns = GridCells.Fixed(2),
        horizontalArrangement = Arrangement.spacedBy(12.dp),
        verticalArrangement = Arrangement.spacedBy(12.dp),
        modifier = Modifier.height(300.dp)
    ) {
        items(genres) { genre ->
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(80.dp)
                    .background(
                        Brush.linearGradient(
                            colors = listOf(
                                Color(0xFF6A5AE0),
                                Color(0xFF8A7DF2)
                            )
                        )
                    )
                    .clickable { onGenreClick(genre) }
                    .padding(16.dp),
                contentAlignment = Alignment.Center
            ) {
                Text(genre.replaceFirstChar { it.uppercase() }, color = Color.White)
            }
        }
    }
}

@Composable
fun BooksGrid(books: List<BookDto>, onBookClick: (Long) -> Unit) {
    LazyVerticalGrid(
        columns = GridCells.Fixed(2),
        verticalArrangement = Arrangement.spacedBy(16.dp),
        horizontalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        items(books) { book ->
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .clickable { onBookClick(book.id) }
            ) {
                AsyncImage(
                    model = book.smallImageURL,
                    contentDescription = null,
                    modifier = Modifier.fillMaxWidth().height(150.dp)
                )
                Text(book.title)
                Text(book.author)
            }
        }
    }
}
