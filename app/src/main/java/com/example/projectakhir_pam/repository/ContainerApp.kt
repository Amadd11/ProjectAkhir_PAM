package com.example.projectakhir_pam.repository

import android.content.Context
import com.example.projectakhir_pam.data.DatabasePemesan

interface ContainerApp {
    val repositoryPemesan : RepositoryPemesan
}

class ContainerDataApp(private val context: Context): ContainerApp{
    override val repositoryPemesan: RepositoryPemesan by lazy{
        OfflineRepositoryPemesan(DatabasePemesan.getDatabase(context).pemesanDao())
    }
}