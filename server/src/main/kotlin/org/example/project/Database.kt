package org.example.project

// import org.jetbrains.kotlinx.dataframe.io.DbConnectionConfig
import org.jetbrains.exposed.v1.jdbc.Database
import org.jetbrains.exposed.v1.core.Table



//val dbConfig = DbConnectionConfig(
//    url = "jdbc:postgresql://localhost:5432/mydb",
//    user = "postgres",
//    password = "secret"
//)

fun init_db(){
    Database.connect(
        url = "jdbc:postgresql:${POSTGRES_HOST}:${POSTGRES_PORT}",
        driver = "org.postgresql.Driver",
        user = POSTGRES_USER,
        password = POSTGRES_PASSWORD
    )
}
