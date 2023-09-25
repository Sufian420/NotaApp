package com.example.notaapp

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
@Entity
data class Contact(
    @PrimaryKey(autoGenerate = true)
    val id:Int?=0,
    @ColumnInfo("Full_Name")
    val name:String,
    val email:String,
    val phone:String
)
