package com.digitalrecord.app.data.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface HouseDao {

    @Insert
    suspend fun insertHouse(house: HouseEntity)

    @Query("SELECT * FROM house_records")
    suspend fun getAllHouses(): List<HouseEntity>
}
