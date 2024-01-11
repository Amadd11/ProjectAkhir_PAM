package com.example.projectakhir_pam.repository

import com.example.projectakhir_pam.data.Pemesan
import com.example.projectakhir_pam.data.PemesanDao
import kotlinx.coroutines.flow.Flow

class OfflineRepositoryPemesan(private val pemesanDao: PemesanDao): RepositoryPemesan{
    override fun getAllPemesanStream(): Flow<List<Pemesan>> = pemesanDao.getAllPemesan()

    override fun getPemesanStream(id: Int): Flow<Pemesan?> = pemesanDao.getPemesan(id)

    override suspend fun insertPemesan(pemesan: Pemesan) = pemesanDao.insert(pemesan)

    override suspend fun deletePemesan(pemesan: Pemesan) = pemesanDao.delete(pemesan)

    override suspend fun updatePemesan(pemesan: Pemesan) = pemesanDao.update(pemesan)

}