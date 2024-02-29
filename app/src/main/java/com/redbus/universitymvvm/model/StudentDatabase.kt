package com.redbus.universitymvvm.model

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase


@Database(entities = [Student::class], version = 1)
abstract class StudentDatabase: RoomDatabase() {

    abstract fun stdDao() : StudentDao

    companion object {
        private var instance: StudentDatabase? = null

        fun getInstance(ctx: Context): StudentDatabase {
            return instance ?: createDB(ctx).also {
                instance = it
            }
        }

        private fun createDB(ctx: Context): StudentDatabase {
           return Room.databaseBuilder(ctx.applicationContext,
                StudentDatabase::class.java, "students.db")
                .build()
        }
    }
}