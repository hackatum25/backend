package org.example.project.db

import org.example.project.LONG_STRING_LENGTH
import org.example.project.SHORT_STRING_LENGTH
import org.example.project.model.Post
import org.jetbrains.exposed.v1.core.dao.id.EntityID
import org.jetbrains.exposed.v1.core.dao.id.IntIdTable
import org.jetbrains.exposed.v1.dao.IntEntity
import org.jetbrains.exposed.v1.dao.IntEntityClass

object PostTable : IntIdTable() {
    val title = varchar("title", SHORT_STRING_LENGTH)
    val description = varchar("description", LONG_STRING_LENGTH)
}

class PostDAO(id: EntityID<Int>) : IntEntity(id) {
    companion object : IntEntityClass<PostDAO>(PostTable)

    var title by PostTable.title
    var despcription by PostTable.description
}

fun daoToModel(dao: PostDAO) = Post(
    dao.title,
    dao.despcription,
    0,
    0
)
