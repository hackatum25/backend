package org.example.project.routes

import io.ktor.http.HttpStatusCode
import io.ktor.server.request.receive
import io.ktor.server.response.respond
import io.ktor.server.routing.Route
import io.ktor.server.routing.get
import io.ktor.server.routing.post
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
    post("/posts"){
        val post = call.receive<Post>()
        postsRepository.newPost(post)
        call.respond(status = HttpStatusCode.Created, message = post)
    }

}
