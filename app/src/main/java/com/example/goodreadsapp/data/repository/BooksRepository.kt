package com.example.goodreadsapp.data.repository

import com.example.goodreadsapp.data.network.GoodreadsApiService

class BooksRepository(
    private val api: GoodreadsApiService
) {

    suspend fun getBestBooks(genre: String) = api.getBestBooks(genre)
}
