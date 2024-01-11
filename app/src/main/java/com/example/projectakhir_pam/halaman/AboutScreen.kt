package com.example.projectakhir_pam.halaman

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.projectakhir_pam.R
import com.example.projectakhir_pam.navigasi.DestinasiNavigasi
import com.example.projectakhir_pam.navigasi.HotelTopAppBar

object AboutDestination : DestinasiNavigasi {
    override val route = "about"
    override val titleRes = R.string.screen_about
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AboutScreen(
    navController: NavHostController,
    navigateBack: () -> Unit
) {
    Scaffold(
        topBar = {
            HotelTopAppBar(
                title = stringResource(AboutDestination.titleRes),
                canNavigateBack = true,
                navigateUp = navigateBack
            )

        },
    ) { innerPadding ->

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Card(
                modifier = Modifier
                    .fillMaxWidth(),
            ) {
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center,
                    modifier = Modifier
                        .padding(16.dp)
                        .align(Alignment.CenterHorizontally)
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.hotel_about),
                        contentDescription = "App Icon",
                        modifier = Modifier
                            .size(300.dp)
                            .padding(bottom = 16.dp),
                        contentScale = ContentScale.FillBounds
                    )

                    Text(
                        text = "Hotel Explorer",
                        fontSize = 24.sp,
                        fontWeight = FontWeight.Bold
                    )

                    Spacer(modifier = Modifier.height(16.dp))

                    Text(
                        text = "Discover the best hotel experience and explore millions of hotels around the world with Hotel Explorer.",
                        fontSize = 15.sp,
                        textAlign = TextAlign.Center
                    )
                }

            }

        }
    }
}