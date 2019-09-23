package com.exposed.example.data

object UserTable : UniqueIdTable(name = "user") {
    val firstName = varchar("first_name", 255)
    val lastName = varchar("last_name", 255)
    val userCode = varchar("user_code", 255).nullable()
}
