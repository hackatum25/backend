package org.example.project.routes

import io.ktor.http.HttpStatusCode
import io.ktor.server.request.receive
import io.ktor.server.response.respond
import io.ktor.server.routing.Route
import io.ktor.server.routing.get
import io.ktor.server.routing.post
import io.ktor.server.sessions.get
import io.ktor.server.sessions.sessions
import io.ktor.server.util.getValue
import org.example.project.model.ExtendedPost
import org.example.project.model.Post
import org.example.project.repositories.PostsRepository
import org.example.project.UserSession

fun Route.postRoutes() {
    val postsRepository = PostsRepository()


    get("/posts") {
        requireLogin(call)?.let {
            val posts: List<ExtendedPost> = postsRepository.allPosts(it)
            call.respond(posts)
        }
    }

    get("/posts/{id}") {
        val id: Int by call.parameters
        requireLogin(call)?.let {
            val extendedPost: ExtendedPost = postsRepository.getPost(id, it)
            call.respond(extendedPost)
        }
    }
    post("/posts"){
        val post = call.receive<Post>()
        requireLogin(call)?.let {
            val userID = call.sessions.get<UserSession>()?.userId
            if(userID == null){
                call.respond(HttpStatusCode.BadRequest, "Not logged in")
            } else {
                val postDAO = postsRepository.newPost(post, userID)
                postsRepository.addTags(postDAO.id, post.tags)
                call.respond(status = HttpStatusCode.Created, message = post)
            }
        }
    }
}
