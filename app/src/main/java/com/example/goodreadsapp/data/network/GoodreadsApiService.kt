package com.example.goodreadsapp.data.network

import com.example.goodreadsapp.data.model.BookDto
import com.example.goodreadsapp.data.model.GenreBooksResponse
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface GoodreadsApiService {

    @GET("genres/{genre}/best")
    suspend fun getBestBooksByGenre(
        @Path("genre") genre: String
    ): GenreBooksResponse

    @GET("search")
    suspend fun searchBooks(
        @Query("q") query: String
    ): List<BookDto>

}
