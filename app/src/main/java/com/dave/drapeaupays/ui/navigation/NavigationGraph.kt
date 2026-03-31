package com.dave.drapeaupays.ui.navigation

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.dave.drapeaupays.CountryList
import com.dave.drapeaupays.CountryTopAppBar
import com.dave.drapeaupays.data.DataSource
import com.dave.drapeaupays.ui.WelcomeScreen

@Composable
fun NavigationGraph() {
    val navController = rememberNavController()
    
    NavHost(
        navController = navController,
        startDestination = "welcome"
    ) {
        composable("welcome") {
            WelcomeScreen(navController = navController)
        }
        composable("country_list") {
            Scaffold(
                topBar = {
                    CountryTopAppBar()
                }
            ) { innerPadding ->
                CountryList(
                    countries = DataSource().loadCountries(),
                    modifier = Modifier.padding(innerPadding)
                )
            }
        }
    }
}
