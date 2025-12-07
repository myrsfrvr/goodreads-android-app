package com.example.goodreadsapp.ui.screens

import androidx.compose.runtime.mutableStateListOf
import androidx.lifecycle.ViewModel
import com.example.goodreadsapp.data.model.BookDto

//class MyBooksViewModel : ViewModel() {
//
//    val readingBooks = mutableStateListOf<BookDto>()
//    val wantToReadBooks = mutableStateListOf<BookDto>()
//    val readBooks = mutableStateListOf<BookDto>()
//
//    // For demo purposes: add a book to a list
//    fun addBookToList(book: BookDto, listType: BookListType) {
//        when (listType) {
//            BookListType.Reading -> readingBooks.add(book)
//            BookListType.WantToRead -> wantToReadBooks.add(book)
//            BookListType.Read -> readBooks.add(book)
//        }
//    }
//}

class MyBooksViewModel : ViewModel() {

    val readingBooks = mutableStateListOf<BookDto>()
    val wantToReadBooks = mutableStateListOf<BookDto>()
    val readBooks = mutableStateListOf<BookDto>()

    init {
        preloadBooks()
    }

    private fun preloadBooks() {
        readingBooks.add(
            BookDto(
                id = 5907,
                title = "The Hobbit, or There and Back Again",
                author = "J.R.R. Tolkien",
                smallImageURL = "https://i.gr-assets.com/images/S/compressed.photo.goodreads.com/books/1546071216l/5907._SY75_.jpg",
                publicationYear = 2012,
                url="https://www.goodreads.com/book/show/76703559-throne-of-glass",
                rating=4.18,
                ratings=2333891
            )
        )

        wantToReadBooks.add(
            BookDto(
                id = 76703559,
                title = "Throne of Glass",
                author = "Sarah J. Maas",
                smallImageURL = "https://i.gr-assets.com/images/S/compressed.photo.goodreads.com/books/1673566495l/76703559._SY75_.jpg",
                publicationYear = 2012,
                url="https://www.goodreads.com/book/show/76703559-throne-of-glass",
                rating=4.18,
                ratings=2333891
            )

        )

        wantToReadBooks.add(
            BookDto(
                id = 5907,
                title = "The Hobbit, or There and Back Again",
                author = "J.R.R. Tolkien",
                smallImageURL = "https://i.gr-assets.com/images/S/compressed.photo.goodreads.com/books/1546071216l/5907._SY75_.jpg",
                publicationYear = 2012,
                url="https://www.goodreads.com/book/show/76703559-throne-of-glass",
                rating=4.18,
                ratings=2333891
            )

        )

        readBooks.add(
            BookDto(
                id = 132080146,
                title = "The Lion, the Witch and the Wardrobe",
                author = "C.S. Lewis",
                smallImageURL = "https://i.gr-assets.com/images/S/compressed.photo.goodreads.com/books/1697079942l/132080146._SY75_.jpg",
                publicationYear = 2012,
                url="https://www.goodreads.com/book/show/76703559-throne-of-glass",
                rating=4.18,
                ratings=2333891
            )
        )

        readBooks.add(
            BookDto(
                id = 26032825,
                title = "The Cruel Prince",
                author = "Holly Black",
                smallImageURL = "https://i.gr-assets.com/images/S/compressed.photo.goodreads.com/books/1574535986l/26032825._SY75_.jpg",
                publicationYear = 2012,
                url="https://www.goodreads.com/book/show/76703559-throne-of-glass",
                rating=4.18,
                ratings=2333891
            )
        )

        readBooks.add(
            BookDto(
                id = 37834723,
                title = "Shadow and Bone",
                author = "Leigh Bardugo",
                smallImageURL = "https://i.gr-assets.com/images/S/compressed.photo.goodreads.com/books/1519072763l/37834723._SY75_.jpg",
                publicationYear = 2012,
                url="https://www.goodreads.com/book/show/76703559-throne-of-glass",
                rating=4.18,
                ratings=2333891
            )
        )
    }

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
