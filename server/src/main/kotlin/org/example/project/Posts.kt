package org.example.project

import org.jetbrains.exposed.v1.core.Table

object PostsTable : Table() {
    val id = integer("id").autoIncrement()
    val sequelId = integer("sequel_id").uniqueIndex()
    val name = varchar("name", MAX_DB_VARCHAR_LENGTH)
    val director = varchar("director", MAX_DB_VARCHAR_LENGTH)
}