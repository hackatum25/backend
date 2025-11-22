package org.example.project.routes

import io.ktor.http.HttpStatusCode
import io.ktor.server.request.receive
import io.ktor.server.response.respond
import io.ktor.server.routing.Route
import io.ktor.server.routing.get
import io.ktor.server.routing.post
import io.ktor.server.sessions.sessions
import io.ktor.server.sessions.get
import org.example.project.model.Post
import org.example.project.UserSession
import org.example.project.model.Rating
import org.example.project.repositories.RatingRepository

fun Route.ratingRoutes() {
    val ratingRepository = RatingRepository()

    post("/posts/{id}/vote"){
        val rating = call.receive<Rating>()
        val userSession = call.sessions.get<UserSession>()
        if (userSession == null){
            call.respond(HttpStatusCode.BadRequest, "Not logged in")
        } else {
            val userID = userSession.userId
            val existing = ratingRepository.getRating(rating.post, userID)
            if(existing != null){
                ratingRepository.updateRating(existing, rating.rating)
            } else {
                ratingRepository.newRating(rating, userID)
            }
        }
        call.respond(HttpStatusCode.OK)
    }

}
