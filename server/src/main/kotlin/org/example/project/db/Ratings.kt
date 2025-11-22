package org.example.project.db

import org.jetbrains.exposed.v1.core.dao.id.EntityID
import org.jetbrains.exposed.v1.core.dao.id.IntIdTable
import org.jetbrains.exposed.v1.dao.IntEntity
import org.jetbrains.exposed.v1.dao.IntEntityClass

object RatingTable : IntIdTable() {
    val user = reference("user", UserTable)
    val post = reference("post", PostTable)
    val rating = integer("rating")
}

class RatingDAO(id: EntityID<Int>) : IntEntity(id) {
    companion object : IntEntityClass<RatingDAO>(RatingTable)

    var user by RatingTable.user
    var post by RatingTable.post
    var rating by RatingTable.rating
}
