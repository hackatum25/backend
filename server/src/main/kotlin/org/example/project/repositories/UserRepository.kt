package org.example.project.repositories

import org.jetbrains.exposed.v1.jdbc.transactions.suspendTransaction
import org.example.project.db.UserDAO
import org.example.project.db.findIdByUsername

class UserRepository {
    suspend fun getUser(username: String) : Int? =
        suspendTransaction {
            findIdByUsername(username)
        }

}