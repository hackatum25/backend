package org.example.project.db

import kotlinx.datetime.LocalDateTime
import org.example.project.LONG_STRING_LENGTH
import org.example.project.SHORT_STRING_LENGTH
import org.example.project.model.ExtendedPost
import org.jetbrains.exposed.v1.core.and
import org.jetbrains.exposed.v1.core.dao.id.EntityID
import org.jetbrains.exposed.v1.core.dao.id.IntIdTable
import org.jetbrains.exposed.v1.core.eq
import org.jetbrains.exposed.v1.dao.IntEntity
import org.jetbrains.exposed.v1.dao.IntEntityClass
import org.jetbrains.exposed.v1.datetime.*

object PostTable : IntIdTable() {
    val title = varchar("title", SHORT_STRING_LENGTH)
    val description = varchar("description", LONG_STRING_LENGTH)
    val createdAt = datetime("created_at").defaultExpression(CurrentDateTime)

    val createdBy = reference("created_by", UserTable)
}

class PostDAO(id: EntityID<Int>) : IntEntity(id) {
    companion object : IntEntityClass<PostDAO>(PostTable)

    var title by PostTable.title
    var description by PostTable.description
    var createdAt: LocalDateTime by PostTable.createdAt

    var createdBy by PostTable.createdBy
}

fun fullName(dao: PostDAO): String {
    var row = UserDAO.findById(dao.createdBy)
    if (row == null) {return ""} else {
        return row.firstName + row.lastName
    }
}

fun daoToModel(dao: PostDAO, userID: Int) = ExtendedPost(
    dao.id.value,
    dao.title,
    dao.description,
    dao.createdAt,
    RatingDAO.find { (RatingTable.rating eq 1) and (RatingTable.post eq dao.id) }.count().toInt(),
    RatingDAO.find { (RatingTable.rating eq 1) and (RatingTable.post eq dao.id) }.count().toInt(),
    RatingDAO.find { (RatingTable.user eq userID) and (RatingTable.post eq dao.id) }.firstOrNull()?.rating,
    fullName(dao),
    UserDAO.findById(dao.createdBy)!!.verified,
    TagDAO.find { TagTable.post eq dao.id }.map { t -> t.tag }.toList()
)

