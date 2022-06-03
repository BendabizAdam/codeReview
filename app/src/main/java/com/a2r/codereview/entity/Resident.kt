package com.a2r.codereview.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "resident_table")
data class Resident(
    @PrimaryKey
    val name: String,
    val age: Int
)