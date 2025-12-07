package com.example.goodreadsapp.data.repository

import com.example.goodreadsapp.data.model.BookDto
import com.example.goodreadsapp.data.network.GoodreadsApiService

class BooksRepository(
    private val api: GoodreadsApiService
) {

    suspend fun getBestBooks(genre: String) = api.getBestBooksByGenre(genre)

//    suspend fun searchBooks(query: String): List<BookDto> {
//        return api.searchBooks(query)
//    }
//
//    suspend fun getBestBooksByGenre(genre: String): List<BookDto> {
//        return api.getBestBooksByGenre(genre).books
//    }

    suspend fun searchBooks(query: String): List<BookDto> =
        api.searchBooks(query)

    suspend fun getBestBooksByGenre(genre: String): List<BookDto> =
        api.getBestBooksByGenre(genre).books

}
