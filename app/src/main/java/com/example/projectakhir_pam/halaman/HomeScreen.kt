package com.example.projectakhir_pam.halaman

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Card
import androidx.compose.material3.Divider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.projectakhir_pam.R


@Composable
fun CardScreen(
    navController: NavHostController
) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(10.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {

        Text(
            text = "Menu",
            fontSize = 24.sp,
            color = Color.Black,
            modifier = Modifier.align(Alignment.Start)
        )
        Divider(
            modifier = Modifier.padding(vertical = 10.dp),
            color = Color.White,
            thickness = 2.dp
        )

        Spacer(modifier = Modifier.width(16.dp))
        // Card 1
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .clickable {navController.navigate(OrderDestination.route)}
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(200.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                Image(
                    painter = painterResource(id = R.drawable.background),
                    contentDescription = "Reservasi Hotel",
                    modifier = Modifier
                        .padding(8.dp)
                        .fillMaxWidth()
                        .height(150.dp)
                        .align(Alignment.CenterHorizontally),
                    contentScale = ContentScale.Crop

                )
                Text(
                    text = "Pilih Hotel",
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold,
                    fontFamily = FontFamily.Monospace)

            }
        }

        Spacer(modifier = Modifier.height(30.dp))

        // Card 2 and Card 3 side by side
        Row(
            modifier = Modifier
                .width(300.dp)
                .height(200.dp),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            // Card 2
            Card(
                modifier = Modifier
                    .width(150.dp)
                    .height(200.dp)
                    .clickable { navController.navigate(AboutDestination.route) },

                ) {
                Column(
                    modifier = Modifier
                        .fillMaxSize(),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.about),
                        contentDescription = "Tentang Aplikasi",
                        modifier = Modifier.height(100.dp),
                    )
                    Spacer(modifier = Modifier.padding(5.dp))
                    Divider(
                        modifier = Modifier.padding(vertical = 10.dp),
                        color = Color.Black,
                        thickness = 2.dp
                    )
                    Text(text = "Tentang Aplikasi", fontSize = 16.sp)
                }
            }

            Spacer(modifier = Modifier.width(10.dp))

            // Card 3
            Card(
                modifier = Modifier
                    .width(150.dp)
                    .height(200.dp)
                    .clickable { navController.navigate(HistoryDestination.route) },
            ) {
                Column(
                    modifier = Modifier.fillMaxSize(),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.paper),
                        contentDescription = "Your Order",
                        modifier = Modifier.height(100.dp),
                    )
                    Spacer(modifier = Modifier.padding(5.dp))
                    Divider(
                        modifier = Modifier.padding(vertical = 10.dp),
                        color = Color.Black,
                        thickness = 2.dp
                    )
                    Text(text = "Riwayat", fontSize = 16.sp)


                }
            }
        }
    }
}