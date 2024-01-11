package com.example.projectakhir_pam.halaman

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Phone
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.projectakhir_pam.R
import com.example.projectakhir_pam.data.Pemesan
import com.example.projectakhir_pam.model.OrderViewModel
import com.example.projectakhir_pam.model.PenyediaViewModel
import com.example.projectakhir_pam.navigasi.DestinasiNavigasi
import com.example.projectakhir_pam.navigasi.HotelTopAppBar

object HistoryDestination : DestinasiNavigasi {
    override val route = "riwayat"
    override val titleRes = R.string.screen_history
}
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HistoryScreen(
    modifier: Modifier = Modifier,
    navigateBack: () -> Unit,
    onDetailClick: (Int) -> Unit = {},
    viewModel: OrderViewModel = viewModel(factory = PenyediaViewModel.Factory)
){
    val scrollBehavior = TopAppBarDefaults.enterAlwaysScrollBehavior()

    Scaffold(
        modifier = modifier.nestedScroll(scrollBehavior.nestedScrollConnection),
        topBar = {
            HotelTopAppBar(
                title = stringResource(HistoryDestination.titleRes),
                canNavigateBack = true,
                scrollBehavior = scrollBehavior,
                navigateUp = navigateBack
            )
        },
    ) { innerpadding ->
        val uiStatePemesan by viewModel.homeUiState.collectAsState()
        BodyHome(
            itemPemesan = uiStatePemesan.listPemesan,
            modifier = Modifier
                .padding(innerpadding)
                .fillMaxSize(),
            onPemesanClick = onDetailClick
        )

    }
}
@Composable
fun BodyHome(
    itemPemesan: List<Pemesan>,
    modifier: Modifier = Modifier,
    onPemesanClick: (Int) -> Unit = {}
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier
    ) {
        if (itemPemesan.isEmpty()) {
            Text(
                text = stringResource(id = R.string.deskripsi_no_item),
                textAlign = TextAlign.Center,
                style = MaterialTheme.typography.titleLarge
            )
        } else {
            ListSiswa(
                itemPemesan = itemPemesan,
                modifier = Modifier.padding(horizontal = dimensionResource(id = R.dimen.padding_small)),
                onItemClick = {onPemesanClick(it.id)}
            )
        }
    }
}
@Composable
fun ListSiswa(
    itemPemesan: List<Pemesan>,
    modifier: Modifier = Modifier,
    onItemClick: (Pemesan) -> Unit
) {
    LazyColumn(modifier = Modifier) {
        items(items = itemPemesan, key = { it.id }) { person ->
            DataHotel(
                pemesan = person,
                modifier = Modifier
                    .padding(dimensionResource(id = R.dimen.padding_small))
                    .clickable { onItemClick(person) }
            )
        }
    }
}
@Composable
fun DataHotel(
    pemesan: Pemesan,
    modifier: Modifier = Modifier
) {
    Card(
        modifier = modifier,
        elevation = CardDefaults.cardElevation(defaultElevation = 2.dp)
    ) {
        Column(
            modifier = Modifier.padding(dimensionResource(id = R.dimen.padding_large)),
            verticalArrangement = Arrangement.spacedBy(dimensionResource(id = R.dimen.padding_small))
        ) {
            Row(
                modifier = Modifier.fillMaxWidth()
            ) {
                Text(
                    text = pemesan.nama,
                    style = MaterialTheme.typography.titleLarge,
                )
                Spacer(Modifier.weight(1f))
                Icon(
                    imageVector = Icons.Default.Phone,
                    contentDescription = null,
                )
                Text(
                    text = pemesan.telpon,
                    style = MaterialTheme.typography.titleMedium
                )
            }
            Text(
                text = pemesan.email,
                style = MaterialTheme.typography.titleMedium
            )
            Text(
                text = pemesan.jumlah,
                style = MaterialTheme.typography.titleMedium
            )
            Text(
                text = pemesan.tanggal,
                style = MaterialTheme.typography.titleMedium
            )
        }
    }
}