package com.example.projectakhir_pam.model

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.example.projectakhir_pam.data.Pemesan
import com.example.projectakhir_pam.repository.RepositoryPemesan

class EntryViewModel(private val repositoryPemesan: RepositoryPemesan): ViewModel() {

    /*
        */
    var uiStatePemesan by mutableStateOf(UIStatePemesan())
        private set

    /* Fungsi untuk memvalidasi input */
    private fun validasiInput(uiState: DetailPemesan = uiStatePemesan.detailPemesan): Boolean {
        return with(uiState){
            nama.isNotBlank() && email.isNotBlank() && telpon.isNotBlank() && jumlah.isNotBlank() && tanggal.isNotBlank()
        }
    }
    fun updateUiState(detailPemesan: DetailPemesan){
        uiStatePemesan = UIStatePemesan(detailPemesan = detailPemesan, isEntryValid = validasiInput(detailPemesan))
    }

    /* Fungsi untuk menyimpan data yang di-entry */
    suspend fun savePemesan(){
        if (validasiInput()) {
            repositoryPemesan.insertPemesan(uiStatePemesan.detailPemesan.toPemesan())
        }
    }
}
data class UIStatePemesan(
    val detailPemesan: DetailPemesan = DetailPemesan(),
    val isEntryValid: Boolean = false
)
data class DetailPemesan(
    val id: Int = 0,
    val nama: String = "",
    val email: String = "",
    val telpon: String = "",
    val jumlah: String = "",
    val tanggal: String = "",
)
/* Fungsi untuk mengkonversi data input ke data dalam tabel sesuai jenis datanya */
fun DetailPemesan.toPemesan(): Pemesan = Pemesan(
    id = id,
    nama = nama,
    email = email,
    telpon = telpon,
    jumlah = jumlah,
    tanggal = tanggal

)

fun Pemesan.toUiStatePemesan(isEntryValid: Boolean = false): UIStatePemesan= UIStatePemesan(
    detailPemesan = this.toDetailPemesan(),
    isEntryValid = isEntryValid
)

fun Pemesan.toDetailPemesan(): DetailPemesan = DetailPemesan(
    id = id,
    nama = nama,
    email = email,
    telpon = telpon,
    jumlah = jumlah,
    tanggal = tanggal
)