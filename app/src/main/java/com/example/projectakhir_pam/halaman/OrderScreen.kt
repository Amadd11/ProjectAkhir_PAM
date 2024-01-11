package com.example.projectakhir_pam.halaman

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
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
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.projectakhir_pam.R
import com.example.projectakhir_pam.navigasi.DestinasiNavigasi
import com.example.projectakhir_pam.navigasi.HotelTopAppBar

object OrderDestination : DestinasiNavigasi {
    override val route = "order"
    override val titleRes = R.string.app_name

    @OptIn(ExperimentalMaterial3Api::class)
    @Composable
    fun OrderScreen(
        navigateBack: () -> Unit,
        modifier: Modifier = Modifier,
        navController: NavHostController
    ) {

        val scrollBehavior = TopAppBarDefaults.enterAlwaysScrollBehavior()

        Scaffold(
            modifier = modifier.nestedScroll(scrollBehavior.nestedScrollConnection),
            topBar = {
                HotelTopAppBar(
                    title = stringResource(DetailDestination.titleRes),
                    canNavigateBack = true,
                    navigateUp = navigateBack,
                    scrollBehavior = scrollBehavior
                )

            },
        )
        { innerPadding ->
            LazyColumn(
                modifier = Modifier
                    .fillMaxSize()
                    .background(color = Color.White)
                    .padding(innerPadding),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                item {
                    Card(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(15.dp)
                            .shadow(10.dp, RoundedCornerShape(16.dp))
                            .background(Color.White, RoundedCornerShape(16.dp))
                            .clickable { navController.navigate(FormDestination.route) }
                    ) {
                        Column(
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(180.dp)
                                .background(Color.Yellow),
                            verticalArrangement = Arrangement.Center,
                            horizontalAlignment = Alignment.CenterHorizontally
                        ) {
                            Row(
                                modifier = Modifier.fillMaxWidth(),
                                horizontalArrangement = Arrangement.Center
                            ) {
                                Image(
                                    painter = painterResource(id = R.drawable.hotel_1),
                                    contentDescription = "Hotel Sanjaya",
                                    modifier = Modifier
                                        .padding(3.dp)
                                        .width(180.dp)
                                        .height(150.dp),
                                    contentScale = ContentScale.Crop
                                )

                                Spacer(modifier = Modifier.width(15.dp))
                                Column(
                                ) {
                                    Text(
                                        text = "Hotel Sanjaya",
                                        fontSize = 20.sp,
                                        fontWeight = FontWeight.Bold
                                    )
                                    Spacer(modifier = Modifier.height(5.dp))
                                    Text(
                                        text = "Single bed",
                                        fontSize = 15.sp
                                    )
                                    Text(
                                        text = "AC",
                                        fontSize = 15.sp
                                    )
                                    Text(
                                        text = "Breakfast",
                                        fontSize = 15.sp
                                    )
                                }

                            }
                        }
                    }

                }
                item {
                    Card(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(15.dp)
                            .shadow(10.dp, RoundedCornerShape(16.dp))
                            .background(Color.White, RoundedCornerShape(16.dp))
                            .clickable { navController.navigate(FormDestination.route) }
                    ) {
                        Column(
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(180.dp)
                                .background(Color.Yellow),
                            verticalArrangement = Arrangement.Center,
                            horizontalAlignment = Alignment.CenterHorizontally
                        ) {
                            Row(
                                modifier = Modifier.fillMaxWidth(),
                                horizontalArrangement = Arrangement.Center
                            ) {
                                Image(
                                    painter = painterResource(id = R.drawable.hotel_2),
                                    contentDescription = "Hotel Padjajaran",
                                    modifier = Modifier
                                        .padding(3.dp)
                                        .width(180.dp)
                                        .height(150.dp),
                                    contentScale = ContentScale.Crop
                                )

                                Spacer(modifier = Modifier.width(15.dp))
                                Column(
                                ) {
                                    Text(
                                        text = "Hotel Padjajaran",
                                        fontSize = 20.sp,
                                        fontWeight = FontWeight.Bold
                                    )
                                    Spacer(modifier = Modifier.height(5.dp))
                                    Text(
                                        text = "Single bed",
                                        fontSize = 15.sp
                                    )
                                    Text(
                                        text = "AC",
                                        fontSize = 15.sp
                                    )
                                    Text(
                                        text = "Breakfast",
                                        fontSize = 15.sp
                                    )
                                }

                            }
                        }
                    }

                }
                item {
                    Card(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(15.dp)
                            .shadow(10.dp, RoundedCornerShape(16.dp))
                            .background(Color.White, RoundedCornerShape(16.dp))
                            .clickable { navController.navigate(FormDestination.route) }
                    ) {
                        Column(
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(180.dp)
                                .background(Color.Yellow),
                            verticalArrangement = Arrangement.Center,
                            horizontalAlignment = Alignment.CenterHorizontally
                        ) {
                            Row(
                                modifier = Modifier.fillMaxWidth(),
                                horizontalArrangement = Arrangement.Center
                            ) {
                                Image(
                                    painter = painterResource(id = R.drawable.hotel_3),
                                    contentDescription = "Hotel Neo",
                                    modifier = Modifier
                                        .padding(3.dp)
                                        .width(180.dp)
                                        .height(150.dp),
                                    contentScale = ContentScale.Crop
                                )

                                Spacer(modifier = Modifier.width(15.dp))
                                Column(
                                ) {
                                    Text(
                                        text = "Hotel Neo",
                                        fontSize = 20.sp,
                                        fontWeight = FontWeight.Bold
                                    )
                                    Spacer(modifier = Modifier.height(5.dp))
                                    Text(
                                        text = "Single bed",
                                        fontSize = 15.sp
                                    )
                                    Text(
                                        text = "AC",
                                        fontSize = 15.sp
                                    )
                                    Text(
                                        text = "Breakfast",
                                        fontSize = 15.sp
                                    )
                                }

                            }
                        }
                    }

                }
                item {
                    Card(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(15.dp)
                            .shadow(10.dp, RoundedCornerShape(16.dp))
                            .background(Color.White, RoundedCornerShape(16.dp))
                            .clickable { navController.navigate(FormDestination.route) }
                    ) {
                        Column(
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(180.dp)
                                .background(Color.Yellow),
                            verticalArrangement = Arrangement.Center,
                            horizontalAlignment = Alignment.CenterHorizontally
                        ) {
                            Row(
                                modifier = Modifier.fillMaxWidth(),
                                horizontalArrangement = Arrangement.Center
                            ) {
                                Image(
                                    painter = painterResource(id = R.drawable.hotel_4),
                                    contentDescription = "Hotel Ryu",
                                    modifier = Modifier
                                        .padding(3.dp)
                                        .width(180.dp)
                                        .height(150.dp),
                                    contentScale = ContentScale.Crop
                                )

                                Spacer(modifier = Modifier.width(15.dp))
                                Column(
                                ) {
                                    Text(
                                        text = "Hotel Ryu",
                                        fontSize = 20.sp,
                                        fontWeight = FontWeight.Bold
                                    )
                                    Spacer(modifier = Modifier.height(5.dp))
                                    Text(
                                        text = "Single bed",
                                        fontSize = 15.sp
                                    )
                                    Text(
                                        text = "AC",
                                        fontSize = 15.sp
                                    )
                                    Text(
                                        text = "Breakfast",
                                        fontSize = 15.sp
                                    )
                                }

                            }
                        }
                    }

                }
            }
        }
    }
}