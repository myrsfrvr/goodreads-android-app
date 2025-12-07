package com.example.goodreadsapp.data.model

data class BookDetailDto(
    val id: String,
    val legacyId: Long,
    val title: String,
    val description: String,
    val imageUrl: String,
    val bookGenres: List<Genre>,
    val author: Author,
    val stats: Stats
) {
    data class Author(
        val id: String,
        val legacyId: Long,
        val name: String,
        val profileImageUrl: String?
    )

    data class Stats(
        val averageRating: Double,
        val ratingsCount: Int
    )

    data class Genre(
        val name: String
    )

}
