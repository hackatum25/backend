package org.example.project.repositories

import org.example.project.db.PostDAO
import org.example.project.db.daoToModel
import org.example.project.model.Post
import org.jetbrains.exposed.v1.jdbc.insert
import org.jetbrains.exposed.v1.jdbc.transactions.suspendTransaction
import org.example.project.db.PostTable

class PostsRepository {
    suspend fun getPost(postId: Int): Post = suspendTransaction {
        daoToModel(PostDAO[postId])
    }

    suspend fun newPost(post: Post) : Int = suspendTransaction {
        val mypost = PostTable.insert{
            it[PostTable.title] = post.title
            it[PostTable.description] = post.description
        }
        return@suspendTransaction 1
    }

    private suspend fun upvotings(postId: Int) {
        // PostDAO.get(postId)
    }
}