package com.redbus.universitymvvm.model

import android.content.Context
import androidx.lifecycle.LiveData

class Repository(ctx: Context) {

    val dao = StudentDatabase.getInstance(ctx).stdDao()

    suspend fun addStudent(std: Student): Boolean{
        return try {
            dao.addStudent(std)
            true
        }catch (e: Exception){
            false
        }
    }

    fun getAllStudents() : LiveData<List<Student>> {
        return dao.getStudents()
    }

    suspend fun deleteStudent(std: Student){
        dao.deleteStudent(std)
    }

    suspend fun updateStudent(std: Student){
        dao.updateMarks(std)
    }
}