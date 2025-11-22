package org.example.project.routes

import io.ktor.http.HttpStatusCode
import io.ktor.server.request.receiveParameters
import io.ktor.server.response.respondRedirect
import io.ktor.server.routing.Route
import io.ktor.server.routing.post
import org.example.project.repositories.UserRepository
import io.ktor.server.sessions.*
import org.example.project.UserSession


fun Route.userRoutes() {
    val userRepository = UserRepository()
    post("/user") {
        val user = call.receiveParameters()["username"].toString()
        val id = userRepository.getUser(user)
        if(id != null) {
            call.sessions.set(UserSession(id))
            call.respondRedirect("/posts")
        }
    }

}