package com.example.projectakhir_pam.halaman

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Phone
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.unit.dp
import com.example.projectakhir_pam.R
import com.example.projectakhir_pam.data.Pemesan

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