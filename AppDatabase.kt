package com.digitalrecord.app.data.local

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [HouseEntity::class], version = 1)
abstract class AppDatabase : RoomDatabase() {

    abstract fun houseDao(): HouseDao

    companion object {
        @Volatile
        private var INSTANCE: AppDatabase? = null

        fun getDatabase(context: Context): AppDatabase {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    AppDatabase::class.java,
                    "digital_record_db"
                ).build()
                INSTANCE = instance
                instance
            }
        }
    }
}
