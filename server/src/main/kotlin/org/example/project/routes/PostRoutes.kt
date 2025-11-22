package org.example.project.routes

import io.ktor.server.response.respondText
import io.ktor.server.routing.Route
import io.ktor.server.routing.get

fun Route.postRoutes() {
    get("/posts/test") {
        call.respondText("Test")
    }
}
