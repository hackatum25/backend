package org.example.project.routes

import io.ktor.http.HttpStatusCode
import io.ktor.server.request.receive
import io.ktor.server.response.respond
import io.ktor.server.routing.Route
import io.ktor.server.routing.get
import io.ktor.server.routing.post
import io.ktor.server.sessions.sessions
import io.ktor.server.sessions.get
import io.ktor.server.util.getValue
import org.example.project.model.ExtendedPost
import org.example.project.model.Post
import org.example.project.repositories.PostsRepository
import org.example.project.UserSession

fun Route.postRoutes() {
    val postsRepository = PostsRepository()

    get("/posts") {

    }

    get("/posts/{id}") {
        val postID: Int by call.parameters
        val userSession = call.sessions.get<UserSession>()
        if (userSession != null) {
            val extendedPost: ExtendedPost = postsRepository.getPost(postID, userSession.userId)
            call.respond(extendedPost)
        } else {
            call.respond(status = HttpStatusCode.BadRequest, message = "You are not logged in")
        }

    }
    post("/posts"){
        val post = call.receive<Post>()
        postsRepository.newPost(post)
        call.respond(status = HttpStatusCode.Created, message = post)
    }

}
