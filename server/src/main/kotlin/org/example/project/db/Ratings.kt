package org.example.project.db

import org.jetbrains.exposed.v1.core.dao.id.IntIdTable

object Ratings : IntIdTable() {
    val user = reference("user", UserTable)
    val post = reference("post", PostTable)
    val rating = integer("rating")
}
