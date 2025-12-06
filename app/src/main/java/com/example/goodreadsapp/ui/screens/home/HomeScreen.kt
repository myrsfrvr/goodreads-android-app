package com.example.goodreadsapp.ui.screens.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.example.goodreadsapp.R
import com.example.goodreadsapp.data.model.BookDto

@Composable
fun HomeScreen(
    viewModel: HomeViewModel,
    onBookClick: (Long) -> Unit
) {
    val genresMap by viewModel.booksByGenre.collectAsState()

    Column(Modifier.fillMaxSize()) {

        TopBar()

        LazyColumn(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.spacedBy(24.dp)
        ) {
            genresMap.forEach { (genre, books) ->

                val formattedGenre = genre.replace("-", " ").replaceFirstChar { it.uppercase() }


                item {
                    Text(
                        text = "Best $formattedGenre Books",
                        modifier = Modifier.padding(start = 16.dp, end = 16.dp),
                        style = MaterialTheme.typography.titleMedium.copy(
                            fontWeight = FontWeight.Bold
                        )
                    )
                }

                item {
                    BooksGrid(books, onBookClick)
                }
            }
        }
    }
}

@Composable
private fun TopBar() {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        contentAlignment = Alignment.Center
    ) {
        Image(
            painter = painterResource(R.drawable.home_logo),
            contentDescription = null,
            modifier = Modifier.height(40.dp)
        )
    }
}

@Composable
private fun BooksGrid(
    books: List<BookDto>,
    onBookClick: (Long) -> Unit
) {
    LazyVerticalGrid(
        columns = GridCells.Fixed(2),
        contentPadding = PaddingValues(8.dp),
        horizontalArrangement = Arrangement.spacedBy(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp),
        modifier = Modifier.height(300.dp)
    ) {
        items(books) { book ->

            val cleanTitle = remember(book.title) {
                book.title.replace(Regex("\\s*\\(.*?\\)"), "")
            }

            Column(
                modifier = Modifier
                    .padding(4.dp)
                    .fillMaxWidth()
            ) {
                AsyncImage(
                    model = book.smallImageURL,
                    contentDescription = book.title,
                    modifier = Modifier
                        .height(150.dp)
                        .fillMaxWidth()
                )

                Text(
                    text = cleanTitle,
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Bold,
                    color = MaterialTheme.colorScheme.onSurface,
                    modifier = Modifier.padding(top = 4.dp)
                )

                Text(
                    text = book.author,
                    fontSize = 13.sp,
                    color = MaterialTheme.colorScheme.onSurfaceVariant
                )
            }
        }
    }
}
