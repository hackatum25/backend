package org.example.project.model


import kotlinx.serialization.Serializable

@Serializable
data class Rating(
    val user: Int,
    val post: Int,
    val rating: Int
) {}