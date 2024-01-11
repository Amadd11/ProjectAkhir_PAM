package com.example.projectakhir_pam.model

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.projectakhir_pam.repository.RepositoryPemesan
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.filterNotNull
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn

class DetailsViewModel(
    savedStateHandle: SavedStateHandle,
    private val repositoryPemesan: RepositoryPemesan
) : ViewModel() {

    private val pemesanId: Int = checkNotNull(savedStateHandle[DetailDestination.pemesanIdArg])
    val uiState: StateFlow<ItemDetailsUiState> =
        repositoryPemesan.getPemesanStream(pemesanId)
            .filterNotNull()
            .map {
                ItemDetailsUiState(detailPemesan = it.toDetailPemesan())
            }.stateIn(
                scope = viewModelScope,
                started = SharingStarted.WhileSubscribed(TIMEOUT_MILLIS),
                initialValue = ItemDetailsUiState()
            )
    suspend fun deleteItem(){
        repositoryPemesan.deletePemesan(uiState.value.detailPemesan.toPemesan())
    }

    companion object{
        private const val TIMEOUT_MILLIS = 5_000L
    }
}

data class ItemDetailsUiState(
    val outOfStock: Boolean = true,
    val detailPemesan: DetailPemesan = DetailPemesan(),
)