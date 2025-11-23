package org.example.project

import org.example.project.db.PostTable
import org.example.project.db.RatingTable
import org.example.project.db.TagTable
import org.example.project.db.UserTable
import org.jetbrains.exposed.v1.jdbc.Database
import org.jetbrains.exposed.v1.jdbc.SchemaUtils
import org.jetbrains.exposed.v1.jdbc.transactions.transaction


fun init_db(){
    Database.connect(
        url = "jdbc:postgresql://${POSTGRES_HOST}:${POSTGRES_PORT}/${POSTGRES_DB}",
        driver = "org.postgresql.Driver",
        user = POSTGRES_USER,
        password = POSTGRES_PASSWORD
    )
    transaction {
        SchemaUtils.create(PostTable, UserTable, RatingTable, TagTable)
    }
    println("Connected to database")
}
