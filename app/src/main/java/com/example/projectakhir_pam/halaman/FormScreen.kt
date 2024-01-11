package com.example.projectakhir_pam.halaman

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.projectakhir_pam.R
import com.example.projectakhir_pam.model.DetailPemesan
import com.example.projectakhir_pam.model.EntryViewModel
import com.example.projectakhir_pam.model.UIStatePemesan
import com.example.projectakhir_pam.navigasi.DestinasiNavigasi
import com.example.projectakhir_pam.navigasi.HotelTopAppBar
import kotlinx.coroutines.launch

object FormDestination : DestinasiNavigasi {
    override val route = "item_entry"
    override val titleRes = R.string.app_name
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun FormScreen(
    navigateNext:() -> Unit,
    navigateBack: () -> Unit,
    modifier: Modifier = Modifier,
    entryViewModel: EntryViewModel = viewModel(factory = PenyediaViewModel.Factory),
){
    val coroutineScope = rememberCoroutineScope()
    val scrollBehavior = TopAppBarDefaults.enterAlwaysScrollBehavior()
    Scaffold(
        modifier = modifier.nestedScroll(scrollBehavior.nestedScrollConnection),
        topBar = {
            HotelTopAppBar(
                title = stringResource(FormDestination.titleRes),
                canNavigateBack = true,
                scrollBehavior = scrollBehavior,
                navigateUp = navigateBack
            )
        }
    ) { innerPadding ->
        EntryBody(
            uiStatePemesan = entryViewModel.uiStatePemesan,
            onPemesanValueChange = entryViewModel::updateUiState,
            onSaveClick = {
                coroutineScope.launch {
                    entryViewModel.savePemesan()
                    navigateNext()
                }
            },
            modifier = Modifier
                .padding(innerPadding)
                .verticalScroll(rememberScrollState())
                .fillMaxWidth()
        )
    }
}
@Composable
fun EntryBody(
    uiStatePemesan: UIStatePemesan,
    onPemesanValueChange: (DetailPemesan) -> Unit,
    onSaveClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Column(
        verticalArrangement = Arrangement.spacedBy(dimensionResource(id = R.dimen.padding_large)),
        modifier = modifier.padding(dimensionResource(id = R.dimen.padding_medium))
    ) {
        FormInput(
            detailPemesan = uiStatePemesan.detailPemesan,
            onValueChange = onPemesanValueChange,
            modifier = Modifier.fillMaxWidth()
        )
        Button(
            onClick = onSaveClick,
            enabled = uiStatePemesan.isEntryValid,
            shape = MaterialTheme.shapes.small,
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(stringResource(id = R.string.btn_submit))
        }
    }
}
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun FormInput(
    detailPemesan: DetailPemesan,
    modifier: Modifier = Modifier,
    onValueChange: (DetailPemesan) -> Unit = {},
    enabled: Boolean = true
){
    Card (modifier = modifier,
        elevation = CardDefaults.cardElevation(defaultElevation = 5.dp)){
        Column(
            verticalArrangement = Arrangement.spacedBy(10.dp),
            modifier = Modifier
                .padding(20.dp)
                .fillMaxSize(),
        ){
            Text(text = "Harap di Isi",
                textAlign = TextAlign.Center,
                fontWeight = FontWeight.Bold,
                fontSize = 20.sp,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 10.dp)
            )
            OutlinedTextField(
                value = detailPemesan.nama,
                onValueChange = { onValueChange(detailPemesan.copy(nama = it)) },
                label = { Text("Nama") },
                modifier = Modifier.fillMaxWidth(),
                enabled = enabled,
                singleLine = true
            )
            OutlinedTextField(
                value = detailPemesan.email,
                onValueChange = { onValueChange(detailPemesan.copy(email = it)) },
                label = { Text("Email") },
                modifier = Modifier.fillMaxWidth(),
                enabled = enabled,
                singleLine = true
            )
            OutlinedTextField(
                value = detailPemesan.telpon,
                onValueChange = { onValueChange(detailPemesan.copy(telpon = it)) },
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                label = { Text(text = "Telepon") },
                modifier = Modifier.fillMaxWidth(),
                enabled = enabled,
                singleLine = true
            )
            OutlinedTextField(
                value = detailPemesan.tanggal,
                onValueChange = { onValueChange(detailPemesan.copy(tanggal = it)) },
                label = { Text("Tanggal Check-In") },
                modifier = Modifier.fillMaxWidth(),
                enabled = enabled,
                singleLine = true
            )
            OutlinedTextField(
                value = detailPemesan.jumlah,
                onValueChange = { onValueChange(detailPemesan.copy(jumlah = it)) },
                label = { Text("Jumlah Penginap") },
                modifier = Modifier.fillMaxWidth(),
                enabled = enabled,
                singleLine = true
            )
            if (enabled){
                Text(
                    stringResource(id = R.string.required_field),
                    modifier = Modifier.padding(start = dimensionResource(id = R.dimen.padding_medium))
                )
            }
            Divider(
                thickness = dimensionResource(id = R.dimen.padding_small),
                modifier = Modifier.padding(bottom = dimensionResource(id = R.dimen.padding_medium))
            )
        }
    }

}