package com.exposed.example.data

import org.jetbrains.exposed.dao.Entity
import org.jetbrains.exposed.dao.EntityClass
import org.jetbrains.exposed.dao.EntityID
import org.jetbrains.exposed.dao.IdTable
import org.jetbrains.exposed.sql.Column

open class UniqueIdTable(name: String = "", columnName: String = "id") : IdTable<String>(name) {
    private val generator = UniqueIdGenerator(RandomUniqueIdSeeder())

    override val id: Column<EntityID<String>> = varchar(columnName, 255)
        .primaryKey()
        .clientDefault { generator.next() }
        .entityId()
}

abstract class UniqueIdEntity(id: EntityID<String>) : Entity<String>(id)

abstract class UniqueIdEntityClass<out E : UniqueIdEntity>(table: IdTable<String>, entityType: Class<E>? = null) :
    EntityClass<String, E>(table, entityType)
