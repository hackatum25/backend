package org.example.project

import org.jetbrains.exposed.v1.core.dao.id.IntIdTable

object Posts : IntIdTable() {
    val title = varchar("title", MAX_TITLE_LENGTH)
    val description = varchar("description", MAX_DESCRIPTION_LENGTH)
}