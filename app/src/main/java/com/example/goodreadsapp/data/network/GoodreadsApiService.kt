package com.example.goodreadsapp.data.network

import com.example.goodreadsapp.data.model.GenreBooksResponse
import retrofit2.http.GET
import retrofit2.http.Path

interface GoodreadsApiService {

    @GET("genres/{genre}/best")
    suspend fun getBestBooks(
        @Path("genre") genre: String
    ): GenreBooksResponse
}
