package com.example.projectakhir_pam.navigasi

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarScrollBehavior
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.projectakhir_pam.R
import com.example.projectakhir_pam.halaman.AboutDestination
import com.example.projectakhir_pam.halaman.AboutScreen
import com.example.projectakhir_pam.halaman.DetailDestination
import com.example.projectakhir_pam.halaman.DetailScreen
import com.example.projectakhir_pam.halaman.EditDestination
import com.example.projectakhir_pam.halaman.EditScreen
import com.example.projectakhir_pam.halaman.FormDestination
import com.example.projectakhir_pam.halaman.FormScreen
import com.example.projectakhir_pam.halaman.HistoryDestination
import com.example.projectakhir_pam.halaman.HistoryScreen
import com.example.projectakhir_pam.halaman.HomeDestination
import com.example.projectakhir_pam.halaman.HomeScreen
import com.example.projectakhir_pam.halaman.OrderDestination
import com.example.projectakhir_pam.halaman.OrderDestination.OrderScreen

@Composable
fun HotelApp(navController: NavHostController = rememberNavController()) {
    HostNavigasi(navController = navController)

}
@Composable
fun HostNavigasi(
    navController: NavHostController,
    modifier: Modifier = Modifier
) {
    NavHost(
        navController = navController,
        startDestination = HomeDestination.route,
        modifier = modifier
    )
    {
        composable(OrderDestination.route) {
            OrderScreen(
                navigateBack = { navController.navigate(HomeDestination.route) },
                navController = navController
            )
        }
        composable(AboutDestination.route) {
            AboutScreen(navController = navController,
                navigateBack = { navController.popBackStack() }
            )
        }
        composable(HomeDestination.route) {
            HomeScreen(navController = navController)
        }
        composable(HistoryDestination.route) {
            HistoryScreen(
                onDetailClick = {
                    navController.navigate("${DetailDestination.route}/$it")
                },
                navigateBack = { navController.navigate(HomeDestination.route) }
            )
        }
        composable(FormDestination.route) {
            FormScreen(navigateBack = { navController.navigate(OrderDestination.route)},
                navigateNext = {navController.navigate(HistoryDestination.route)})
        }
        composable(
            DetailDestination.routeWithArgs,
            arguments = listOf(navArgument(DetailDestination.pemesanIdArg) {
                type = NavType.IntType
            })
        ) {
            DetailScreen(
                navigateBack = { navController.popBackStack() },
                navigateToEditItem = {
                    navController.navigate("${EditDestination.route}/$it")
                }
            )
        }
        composable(
            EditDestination.routeWithArgs,
            arguments = listOf(navArgument(EditDestination.itemIdArg) {
                type = NavType.IntType
            })
        ) {
            EditScreen(
                navigateBack = { navController.popBackStack() },
                onNavigateUp = { navController.navigateUp() }
            )
        }

    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HotelTopAppBar(
    title: String,
    canNavigateBack: Boolean,
    modifier: Modifier = Modifier,
    scrollBehavior: TopAppBarScrollBehavior? = null,
    navigateUp: () -> Unit = {}

) {
    CenterAlignedTopAppBar(title = { Text(title) },
        modifier = modifier,
        scrollBehavior = scrollBehavior,
        navigationIcon = {
            if (canNavigateBack) {
                IconButton(onClick = navigateUp) {
                    Icon(
                        imageVector = Icons.Filled.ArrowBack, contentDescription = stringResource(
                            id = R.string.back
                        )
                    )
                }
            }
        }
    )
}