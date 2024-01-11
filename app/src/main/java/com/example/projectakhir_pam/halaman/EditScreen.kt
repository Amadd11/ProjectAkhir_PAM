package com.example.projectakhir_pam.halaman

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.projectakhir_pam.R
import com.example.projectakhir_pam.model.EditViewModel
import com.example.projectakhir_pam.model.PenyediaViewModel
import com.example.projectakhir_pam.navigasi.DestinasiNavigasi
import com.example.projectakhir_pam.navigasi.HotelTopAppBar
import kotlinx.coroutines.launch

object EditDestination : DestinasiNavigasi {
    override val route = "item_edit"
    override val titleRes = R.string.screen_edit
    const val itemIdArg = "itemId"
    val routeWithArgs = "${EditDestination.route}/{$itemIdArg}"
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun EditScreen(
    navigateBack: () -> Unit,
    onNavigateUp: () -> Unit,
    modifier: Modifier = Modifier,
    viewModel: EditViewModel = viewModel(factory = PenyediaViewModel.Factory)
) {
    val coroutineScope = rememberCoroutineScope()
    Scaffold(
        topBar = {
            HotelTopAppBar(
                title = stringResource(EditDestination.titleRes),
                canNavigateBack = true,
                navigateUp = onNavigateUp
            )
        },
        modifier = modifier
    ) { innerPadding ->
        EntryBody(
            uiStatePemesan = viewModel.pemesanUiState,
            onPemesanValueChange = viewModel::updateUiState,
            onSaveClick = {
                coroutineScope.launch {
                    viewModel.updatePemesan()
                    navigateBack()
                }
            },
            modifier = Modifier
                .padding(innerPadding)
                .verticalScroll(rememberScrollState())
                .fillMaxWidth()
        )
    }
}