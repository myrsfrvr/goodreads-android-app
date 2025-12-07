package com.example.goodreadsapp.ui.screens.detail

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.goodreadsapp.data.model.BookDetailDto
import com.example.goodreadsapp.data.repository.BookDetailRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class BookDetailViewModel(private val repo: BookDetailRepository) : ViewModel() {

    private val _book = MutableStateFlow<BookDetailDto?>(null)
    val book: StateFlow<BookDetailDto?> = _book

    fun loadBook(bookId: Long) {
        viewModelScope.launch {
            try {
                _book.value = repo.getBookById(bookId)
            } catch (e: Exception) {
                e.printStackTrace()
                _book.value = null
            }
        }
    }

}