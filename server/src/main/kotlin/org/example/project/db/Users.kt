package org.example.project.db

import org.example.project.SHORT_STRING_LENGTH
import org.jetbrains.exposed.v1.core.dao.id.EntityID
import org.jetbrains.exposed.v1.core.dao.id.IntIdTable
import org.jetbrains.exposed.v1.dao.IntEntity
import org.jetbrains.exposed.v1.dao.IntEntityClass

object UserTable : IntIdTable() {
    val email = varchar("email", SHORT_STRING_LENGTH).uniqueIndex()
    val firstName = varchar("first_name", SHORT_STRING_LENGTH)
    val lastName = varchar("last_name", SHORT_STRING_LENGTH)
}

class UserDAO(id: EntityID<Int>) : IntEntity(id) {
    companion object : IntEntityClass<UserDAO>(UserTable)

    var email by UserTable.email
}
