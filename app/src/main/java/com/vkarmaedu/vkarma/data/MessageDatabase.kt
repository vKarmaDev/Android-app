package com.vkarmaedu.vkarma.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [Message::class], version = 5, exportSchema = false)
abstract class MessageDatabase : RoomDatabase() {

    abstract fun messageDao(): MessageDao

    companion object {
        @Volatile
        private var INSTANCE: MessageDatabase? = null

        fun getDatabase(context: Context): MessageDatabase {
            val tempInstance = INSTANCE
            if (tempInstance != null) {
                return tempInstance
            } else {
                synchronized(this) {
                    if (INSTANCE != null) {
                        return INSTANCE as MessageDatabase
                    }
                    val newInstance =
                        Room.databaseBuilder(context.applicationContext, MessageDatabase::class.java, "messageDatabase")
                            .fallbackToDestructiveMigration()
                            .build()

                    INSTANCE = newInstance
                    return newInstance
                }
            }
        }
    }
}