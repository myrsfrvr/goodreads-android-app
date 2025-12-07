package com.example.goodreadsapp.ui.screens.search

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.goodreadsapp.data.model.BookDto
import com.example.goodreadsapp.data.repository.BooksRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class SearchViewModel(
    private val repository: BooksRepository
) : ViewModel() {

    private val _searchQuery = MutableStateFlow("")
    val searchQuery: StateFlow<String> = _searchQuery

    private val _searchResults = MutableStateFlow<List<BookDto>>(emptyList())
    val searchResults: StateFlow<List<BookDto>> = _searchResults

    fun updateQuery(query: String) {
        _searchQuery.value = query

        if (query.length < 2) {
            _searchResults.value = emptyList()
            return
        }

        viewModelScope.launch {
            _searchResults.value = repository.searchBooks(query)
        }
    }

    private val _genreBooks = MutableStateFlow<List<BookDto>>(emptyList())
    val genreBooks: StateFlow<List<BookDto>> = _genreBooks

    fun loadGenreBooks(genre: String) {
        viewModelScope.launch {
            _genreBooks.value = repository.getBestBooksByGenre(genre)
        }
    }
}
