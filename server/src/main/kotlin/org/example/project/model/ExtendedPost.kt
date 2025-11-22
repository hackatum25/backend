package org.example.project.model

import kotlinx.serialization.Serializable

@Serializable
data class ExtendedPost(
    val title: String,
    val description: String,
    val upvoteCount: Int,
    val downvoteCount: Int,
    val ownRating: Int?
)
