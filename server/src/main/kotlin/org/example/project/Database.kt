package org.example.project

// import org.jetbrains.kotlinx.dataframe.io.DbConnectionConfig
import org.jetbrains.exposed.v1.jdbc.Database
import org.jetbrains.exposed.v1.core.Table
import org.jetbrains.exposed.v1.jdbc.SchemaUtils


//val dbConfig = DbConnectionConfig(
//    url = "jdbc:postgresql://localhost:5432/mydb",
//    user = "postgres",
//    password = "secret"
//)

fun init_db(url: String){
    Database.connect("jdbc:postgresql:$url", driver = "org.postgresql.Driver")
    SchemaUtils.create(Posts)
}
