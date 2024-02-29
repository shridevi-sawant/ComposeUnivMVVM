package com.redbus.universitymvvm.model

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update


@Dao
interface StudentDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun addStudent(std: Student)

    @Delete
    suspend fun deleteStudent(std: Student): Int

    @Query("select * from Student")
    fun getStudents(): LiveData<List<Student>>

    @Update
    suspend fun updateMarks(std: Student): Int

}