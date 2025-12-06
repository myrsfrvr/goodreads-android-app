package com.example.goodreadsapp.ui.screens.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.goodreadsapp.data.model.BookDto
import com.example.goodreadsapp.data.repository.BooksRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class HomeViewModel(
    private val repository: BooksRepository
) : ViewModel() {

    private val genres = listOf("fantasy", "science-fiction", "romance", "horror")

    private val _booksByGenre =
        MutableStateFlow<Map<String, List<BookDto>>>(emptyMap())
    val booksByGenre: StateFlow<Map<String, List<BookDto>>> = _booksByGenre

    init { loadAllGenres() }

    private fun loadAllGenres() {
        viewModelScope.launch {
            val result = mutableMapOf<String, List<BookDto>>()
            for (g in genres) {
                try {
                    val response = repository.getBestBooks(g)
                    result[g] = response.books.take(4)
                } catch (_: Exception) { }
            }
            _booksByGenre.value = result
        }
    }
}
