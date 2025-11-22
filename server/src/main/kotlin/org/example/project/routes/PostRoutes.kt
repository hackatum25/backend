package org.example.project.routes

import io.ktor.server.response.respond
import io.ktor.server.routing.Route
import io.ktor.server.routing.get
import io.ktor.server.util.getValue
import org.example.project.model.Post
import org.example.project.repositories.PostsRepository

fun Route.postRoutes() {
    val postsRepository = PostsRepository()
    get("/posts/{id}") {
        val id: Int by call.parameters
        val post: Post = postsRepository.getPost(id)
        call.respond(post)
    }
}
