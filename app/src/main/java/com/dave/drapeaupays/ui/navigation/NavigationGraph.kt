package com.dave.drapeaupays.ui.navigation

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.dave.drapeaupays.CountryList
import com.dave.drapeaupays.CountryTopAppBar
import com.dave.drapeaupays.data.api.CountryApi
import com.dave.drapeaupays.model.Country
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
        composable(
            route = "country_list/{type}",
            arguments = listOf(navArgument("type") { type = NavType.StringType })
        ) { backStackEntry ->
            val type = backStackEntry.arguments?.getString("type") ?: "all"
            CountryListScreen(type = type)
        }
    }
}

@Composable
fun CountryListScreen(type: String) {
    var countries by remember { mutableStateOf<List<Country>>(emptyList()) }
    var searchQuery by remember { mutableStateOf("") }
    var isLoading by remember { mutableStateOf(true) }
    var errorMessage by remember { mutableStateOf<String?>(null) }

    // Appel API
    LaunchedEffect(type) {
        try {
            val api = CountryApi.create()
            countries = if (type == "africa") {
                api.getCountriesByRegion("africa")
            } else {
                api.getAllCountries()
            }
            isLoading = false
        } catch (e: Exception) {
            errorMessage = "Erreur de chargement : ${e.message}"
            isLoading = false
        }
    }

    // Filtrage
    val filteredCountries = countries.filter {
        it.commonName.contains(searchQuery, ignoreCase = true)
    }

    Scaffold(
        topBar = { CountryTopAppBar() }
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .padding(innerPadding)
                .fillMaxSize()
        ) {
            // Barre de recherche
            SearchBar(query = searchQuery, onQueryChanged = { searchQuery = it })

            if (isLoading) {
                CircularProgressIndicator(modifier = Modifier.align(Alignment.CenterHorizontally))
            } else if (errorMessage != null) {
                Text(text = errorMessage!!, modifier = Modifier.padding(16.dp))
            } else {
                CountryList(countries = filteredCountries)
            }
        }
    }
}

@Composable
fun SearchBar(query: String, onQueryChanged: (String) -> Unit) {
    TextField(
        value = query,
        onValueChange = onQueryChanged,
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp),
        placeholder = { Text("Rechercher un pays...") },
        singleLine = true
    )
}
