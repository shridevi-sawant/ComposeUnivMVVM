package com.redbus.universitymvvm.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Student(
    @PrimaryKey var id: Int,
    var name: String,
    var marks: Int
    )