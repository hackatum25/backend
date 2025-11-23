package org.example.project

import io.ktor.serialization.kotlinx.json.json
import io.ktor.server.application.*
import io.ktor.server.engine.*
import io.ktor.server.netty.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import org.example.project.routes.postRoutes
import io.ktor.server.plugins.contentnegotiation.*
import io.ktor.server.sessions.*
import kotlinx.serialization.Serializable
import org.example.project.routes.ratingRoutes
import org.example.project.routes.userRoutes

fun main() {
    initDB()
    embeddedServer(
        Netty,
        port = SERVER_PORT,
        host = "localhost",
        module = Application::module
    ).start(wait = true)
}

@Serializable
data class UserSession(val userId: Int)

fun Application.module() {
    install(ContentNegotiation) {
        json()
    }
    install(Sessions){
        cookie<UserSession>("user_session", SessionStorageMemory()) {
            cookie.path = "/"
        }
    }
    routing {
        get("/") {
            call.respondText("Ktor: [Greeting]")
        }
        postRoutes()
        userRoutes()
        ratingRoutes()
    }
}
