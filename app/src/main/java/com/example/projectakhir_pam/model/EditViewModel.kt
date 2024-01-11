package com.example.projectakhir_pam.model

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.projectakhir_pam.repository.RepositoryPemesan
import kotlinx.coroutines.flow.filterNotNull
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.launch

class EditViewModel(
    savedStateHandle: SavedStateHandle,
    private val repositoryPemesan: RepositoryPemesan
) : ViewModel() {

    var pemesanUiState by mutableStateOf(UIStatePemesan())
        private set

    private val itemId: Int = checkNotNull(savedStateHandle[EditDestination.itemIdArg])

    init {
        viewModelScope.launch {
            pemesanUiState = repositoryPemesan.getPemesanStream(itemId)
                .filterNotNull()
                .first()
                .toUiStatePemesan(true)
        }
    }

    suspend fun updatePemesan(){
        if (validasiInput(pemesanUiState.detailPemesan)) {
            repositoryPemesan.updatePemesan(pemesanUiState.detailPemesan.toPemesan())
        }
        else{
            println("Data tidak Valid")
        }
    }

    fun updateUiState(detailPemesan: DetailPemesan){
        pemesanUiState =
            UIStatePemesan(detailPemesan = detailPemesan,isEntryValid = validasiInput(detailPemesan))
    }

    private fun validasiInput(uiState: DetailPemesan = pemesanUiState.detailPemesan) : Boolean{
        return with(uiState){
            nama.isNotBlank() && email.isNotBlank() && telpon.isNotBlank() && jumlah.isNotBlank() && tanggal.isNotBlank()
        }
    }
}