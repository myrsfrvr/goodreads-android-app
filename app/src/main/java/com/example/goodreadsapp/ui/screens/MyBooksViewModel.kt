package com.example.goodreadsapp.ui.screens

import androidx.compose.runtime.mutableStateListOf
import androidx.lifecycle.ViewModel
import com.example.goodreadsapp.data.model.BookDto

class MyBooksViewModel : ViewModel() {

    val readingBooks = mutableStateListOf<BookDto>()
    val wantToReadBooks = mutableStateListOf<BookDto>()
    val readBooks = mutableStateListOf<BookDto>()

    // For demo purposes: add a book to a list
    fun addBookToList(book: BookDto, listType: BookListType) {
        when (listType) {
            BookListType.Reading -> readingBooks.add(book)
            BookListType.WantToRead -> wantToReadBooks.add(book)
            BookListType.Read -> readBooks.add(book)
        }
    }
}

enum class BookListType {
    Reading, WantToRead, Read
}
