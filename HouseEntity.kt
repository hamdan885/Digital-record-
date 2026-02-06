package com.digitalrecord.app.data.local

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "house_records")
data class HouseEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val houseNumber: String,
    val headName: String,
    val totalMembers: Int
)
