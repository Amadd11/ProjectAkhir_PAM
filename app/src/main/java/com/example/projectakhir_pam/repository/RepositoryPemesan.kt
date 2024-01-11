package com.example.projectakhir_pam.repository

import com.example.projectakhir_pam.data.Pemesan
import kotlinx.coroutines.flow.Flow

interface RepositoryPemesan {
    fun getAllPemesanStream(): Flow<List<Pemesan>>

    fun getPemesanStream(id: Int): Flow<Pemesan?>

    suspend fun insertPemesan(pemesan: Pemesan)

    suspend fun deletePemesan(pemesan: Pemesan)

    suspend fun updatePemesan(pemesan: Pemesan)
}