package com.example.projectakhir_pam.data

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import kotlinx.coroutines.flow.Flow

@Dao
interface PemesanDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(pemesan: Pemesan)

    @Update
    suspend fun update(pemesan: Pemesan)

    @Delete
    suspend fun delete(pemesan: Pemesan)

    @Query("SELECT * from tblpemesan WHERE id = :id")
    fun getPemesan(id: Int): Flow<Pemesan>

    @Query("SELECT * from tblPemesan ORDER BY nama ASC")
    fun getAllPemesan(): Flow<List<Pemesan>>
}