package org.example.project.repositories

import kotlinx.coroutines.runBlocking
import kotlinx.datetime.toKotlinLocalDateTime
import org.example.project.db.PostDAO
import org.example.project.db.PostTable
import org.example.project.db.TagDAO
import org.example.project.db.UserTable
import org.example.project.db.daoToModel
import org.example.project.model.ExtendedPost
import org.jetbrains.exposed.v1.jdbc.transactions.suspendTransaction
import org.example.project.model.Post
import org.example.project.model.Tag
import org.jetbrains.exposed.v1.core.dao.id.EntityID
import java.time.LocalDateTime

class PostsRepository {
    suspend fun allPosts(userID: Int): List<ExtendedPost> = suspendTransaction {
        PostDAO.all().map { daoToModel(it, userID) }
    }

    suspend fun getPost(postId: Int, userID: Int): ExtendedPost = suspendTransaction {
        daoToModel(PostDAO[postId], userID)
    }

    suspend fun newPost(post: Post, userID: Int) : PostDAO = suspendTransaction {
        PostDAO.new {
            title = post.title
            description = post.description
            createdAt = LocalDateTime.now().toKotlinLocalDateTime()
            createdBy = EntityID<Int>(userID, UserTable)
        }
    }

    suspend fun newTag(postID: EntityID<Int>, mytag: Tag) : Int = suspendTransaction {
        TagDAO.new {
            post = postID
            tag = mytag
        }
        return@suspendTransaction 1
    }

    fun addTags(postID: EntityID<Int>, tags: List<Tag>){
        tags.forEach { runBlocking {newTag(postID, it) }}
    }
}
