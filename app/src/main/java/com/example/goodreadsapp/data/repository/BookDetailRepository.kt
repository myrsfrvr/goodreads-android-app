package com.example.goodreadsapp.data.repository

import com.example.goodreadsapp.data.model.BookDetailDto
import com.example.goodreadsapp.data.network.GoodreadsDetailsApiService

class BookDetailRepository(private val api: GoodreadsDetailsApiService) {
    suspend fun getBookById(legacyId: Long): BookDetailDto = api.getBookById(bookId = legacyId)
}

