package org.example.project.repositories

import org.example.project.db.PostDAO
import org.example.project.db.daoToModel
import org.example.project.model.Post
import org.jetbrains.exposed.v1.jdbc.transactions.suspendTransaction

class PostsRepository {
    suspend fun getPost(postId: Int): Post = suspendTransaction {
        daoToModel(PostDAO[postId])
    }

    private suspend fun upvotings(postId: Int) {
        // PostDAO.get(postId)
    }
}