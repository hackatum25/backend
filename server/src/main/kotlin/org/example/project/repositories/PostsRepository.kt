package org.example.project.repositories

import org.example.project.db.PostDAO
import org.example.project.db.daoToModel
import org.example.project.model.ExtendedPost
import org.jetbrains.exposed.v1.jdbc.transactions.suspendTransaction
import org.example.project.model.Post

class PostsRepository {
    suspend fun allPosts(): List<ExtendedPost> = suspendTransaction {
        PostDAO.all().map { daoToModel(it) }
    }

    suspend fun getPost(postId: Int): ExtendedPost = suspendTransaction {
        daoToModel(PostDAO[postId])
    }

    suspend fun newPost(post: Post) : Int = suspendTransaction {
        PostDAO.new {
            title = post.title
            description = post.description
        }
        return@suspendTransaction 1
    }
}
