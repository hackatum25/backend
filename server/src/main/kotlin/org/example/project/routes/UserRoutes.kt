package org.example.project.routes

import io.ktor.http.HttpStatusCode
import io.ktor.server.request.receive
import io.ktor.server.request.receiveParameters
import io.ktor.server.response.respond
import io.ktor.server.response.respondRedirect
import io.ktor.server.routing.Route
import io.ktor.server.routing.post
import org.example.project.repositories.UserRepository
import io.ktor.server.sessions.*
import kotlinx.serialization.json.JsonElement
import kotlinx.serialization.json.JsonObject
import org.example.project.UserSession
import org.example.project.model.User


fun Route.userRoutes() {
    val userRepository = UserRepository()
    post("/user") {
        val user: User = call.receive<User>()

            val id = userRepository.getUser(user.username)
            if (id != null) {
                call.sessions.set(UserSession(id))
                call.respond("Login successful")
                println("User ${user.username} logged in")
            } else {
                call.respond(HttpStatusCode.BadRequest, "Invalid username")
                println("User not found")
            }
        }


}