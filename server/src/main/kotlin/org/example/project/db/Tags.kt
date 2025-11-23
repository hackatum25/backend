package org.example.project.db

import org.example.project.SHORT_STRING_LENGTH
import org.example.project.model.Tag
import org.jetbrains.exposed.v1.core.dao.id.EntityID
import org.jetbrains.exposed.v1.core.dao.id.IntIdTable
import org.jetbrains.exposed.v1.dao.IntEntity
import org.jetbrains.exposed.v1.dao.IntEntityClass

object TagTable : IntIdTable() {
    val post = reference("post", PostTable)
    val tag = enumeration("tag", Tag::class)
}

class TagDAO(id: EntityID<Int>) : IntEntity(id) {
    companion object : IntEntityClass<TagDAO>(TagTable)

    var post by TagTable.post
    var tag by TagTable.tag
}
