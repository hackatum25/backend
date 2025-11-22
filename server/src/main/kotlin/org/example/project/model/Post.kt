package org.example.project.model

import kotlinx.serialization.Serializable

@Serializable
data class Post(
    val title: String,
    val description: String,
    val upvoteCount: Int,
    val downvoteCount: Int
) {}
