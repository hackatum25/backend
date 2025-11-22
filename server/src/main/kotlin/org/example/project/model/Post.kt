package org.example.project.model

import kotlinx.serialization.Serializable
import org.example.project.db.PostTable

@Serializable
data class Post(
    val title: String,
    val description: String,
    val upvoteCount: Int,
    val downvoteCount: Int
) {}
