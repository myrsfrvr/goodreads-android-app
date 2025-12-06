package com.example.goodreadsapp.data.model

data class GenreBooksResponse(
    val genre: String,
    val books: List<BookDto>
)

data class BookDto(
    val id: Long,
    val url: String,
    val title: String,
    val author: String,
    val smallImageURL: String,
    val rating: Double,
    val ratings: Long,
    val publicationYear: Int?
)
