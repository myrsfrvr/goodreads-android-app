package com.example.goodreadsapp.data.network

import com.example.goodreadsapp.data.model.BookDetailDto
import retrofit2.http.GET
import retrofit2.http.Query

interface GoodreadsDetailsApiService {
    @GET("getBookByID")
    suspend fun getBookById(
        @Query("bookID") bookId: Long
    ): BookDetailDto
}