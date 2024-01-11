package com.example.projectakhir_pam.model

import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.createSavedStateHandle
import androidx.lifecycle.viewmodel.CreationExtras
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.example.projectakhir_pam.HotelApp

object PenyediaViewModel {
    val Factory = viewModelFactory {

        initializer {
            OrderViewModel(aplikasiSiswa().container.repositoryPemesan)
        }

        initializer {
            EntryViewModel(aplikasiSiswa().container.repositoryPemesan)
        }
        initializer {
            DetailsViewModel(
                createSavedStateHandle(),
                aplikasiSiswa().container.repositoryPemesan
            )
        }
        initializer {
            EditViewModel(
                createSavedStateHandle(),
                aplikasiSiswa().container.repositoryPemesan
            )
        }

    }

    fun CreationExtras.aplikasiSiswa(): HotelApp =
        (this[ViewModelProvider.AndroidViewModelFactory.APPLICATION_KEY] as HotelApp)
}