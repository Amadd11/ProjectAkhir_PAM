package com.example.projectakhir_pam.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [Pemesan::class],version = 1, exportSchema = false)
abstract class DatabasePemesan : RoomDatabase(){
    abstract fun pemesanDao() : PemesanDao
    companion object{
        @Volatile
        private var Instance: DatabasePemesan? = null

        fun getDatabase(context: Context): DatabasePemesan{
            return (Instance?: synchronized(this){
                Room.databaseBuilder(context,
                    DatabasePemesan::class.java,"hotel_databasee")
                    .build().also { Instance = it }
            })
        }
    }
}