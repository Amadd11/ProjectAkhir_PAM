package com.example.projectakhir_pam.data

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "tblPemesan")
data class Pemesan(
    @PrimaryKey(autoGenerate = true)
    val id : Int = 0,
    val nama : String,
    val email : String,
    val telpon : String,
    val jumlah : String,
    val tanggal : String
)