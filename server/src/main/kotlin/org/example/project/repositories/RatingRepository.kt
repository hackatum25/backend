package org.example.project.repositories

import org.example.project.db.PostTable
import org.example.project.db.RatingDAO
import org.example.project.db.RatingTable.post
import org.example.project.db.RatingTable.user
import org.example.project.db.UserTable

import org.jetbrains.exposed.v1.jdbc.transactions.suspendTransaction
import org.example.project.model.Rating
import org.jetbrains.exposed.v1.core.and
import org.jetbrains.exposed.v1.core.dao.id.EntityID
import org.jetbrains.exposed.v1.core.eq

class RatingRepository {

    suspend fun getRating(postID: Int, userID: Int) : RatingDAO? = suspendTransaction {
        RatingDAO.find {(user eq userID) and (post eq postID)}.firstOrNull()
    }

    suspend fun updateRating(rate: RatingDAO, vote: Int) = suspendTransaction {
        rate.rating = vote
    }

    suspend fun newRating(rate: Rating, userID: Int) : Int = suspendTransaction {
        RatingDAO.new {
            user = EntityID<Int>(userID, UserTable)
            post = EntityID<Int>(rate.post, PostTable)
            rating = rate.rating
        }
        return@suspendTransaction 1
    }
}
