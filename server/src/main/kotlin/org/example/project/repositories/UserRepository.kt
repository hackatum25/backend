package org.example.project.repositories

import org.jetbrains.exposed.v1.jdbc.transactions.suspendTransaction
import org.example.project.db.UserDAO
import org.example.project.db.findIdByUsername
import org.example.project.model.Profile

class UserRepository {
    suspend fun getUser(username: String) : Int? =
        suspendTransaction {
            findIdByUsername(username)
        }

    suspend fun getProfile(userID: Int) : Profile? =
        suspendTransaction {
            val user = UserDAO.findById(userID)
            if(user == null){
                null
            } else {
                Profile(user.email, user.firstName, user.lastName)
            }
        }

}