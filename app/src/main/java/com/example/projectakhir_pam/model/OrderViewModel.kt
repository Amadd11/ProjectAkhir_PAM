package com.example.projectakhir_pam.model

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.projectakhir_pam.data.Pemesan
import com.example.projectakhir_pam.repository.RepositoryPemesan
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.filterNotNull
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn

class OrderViewModel(private val repositoryPemesan: RepositoryPemesan) : ViewModel() {
    companion object {
        private const val TIMEOUT_MILLIS = 5_000L
    }

    val homeUiState: StateFlow<HomeUiState> = repositoryPemesan.getAllPemesanStream().filterNotNull()
        .map { HomeUiState(listPemesan = it.toList()) }
        .stateIn(
            scope = viewModelScope,
            started = SharingStarted.WhileSubscribed(TIMEOUT_MILLIS),
            initialValue = HomeUiState()
        )

    data class HomeUiState(
        val listPemesan: List<Pemesan> = listOf()
    )

}