package org.example.project.routes

import io.ktor.http.HttpStatusCode
import io.ktor.server.response.respond
import io.ktor.server.routing.RoutingCall
import io.ktor.server.sessions.get
import io.ktor.server.sessions.sessions
import org.example.project.UserSession

suspend fun requireLogin(call: RoutingCall): Int? {
    val userSession = call.sessions.get<UserSession>()
    if (userSession == null) {
        call.respond(status = HttpStatusCode.BadRequest, message = "You are not logged in")
        return null
    }
    return userSession.userId
}
