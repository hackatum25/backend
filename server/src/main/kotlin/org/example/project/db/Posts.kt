package org.example.project.db

import org.example.project.LONG_STRING_LENGTH
import org.example.project.SHORT_STRING_LENGTH
import org.example.project.model.ExtendedPost
import org.jetbrains.exposed.v1.core.and
import org.jetbrains.exposed.v1.core.dao.id.EntityID
import org.jetbrains.exposed.v1.core.dao.id.IntIdTable
import org.jetbrains.exposed.v1.core.eq
import org.jetbrains.exposed.v1.dao.IntEntity
import org.jetbrains.exposed.v1.dao.IntEntityClass

object PostTable : IntIdTable() {
    val title = varchar("title", SHORT_STRING_LENGTH)
    val description = varchar("description", LONG_STRING_LENGTH)
}

class PostDAO(id: EntityID<Int>) : IntEntity(id) {
    companion object : IntEntityClass<PostDAO>(PostTable)

    var title by PostTable.title
    var description by PostTable.description
}

fun daoToModel(dao: PostDAO, userID: Int) = ExtendedPost(
    dao.title,
    dao.description,
    RatingDAO.find { (RatingTable.rating eq 1) and (RatingTable.post eq dao.id) }.count().toInt(),
    RatingDAO.find { (RatingTable.rating eq 1) and (RatingTable.post eq dao.id) }.count().toInt(),
    RatingDAO.find { (RatingTable.user eq userID) and (RatingTable.post eq dao.id) }.firstOrNull()?.rating
)

