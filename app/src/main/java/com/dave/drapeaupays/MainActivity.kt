package com.dave.drapeaupays

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.dave.drapeaupays.ui.theme.DrapeauPaysTheme

// 1. Classe de données pour un Pays
data class Country(
    val name: String,
    val capital: String,
    val code: String,
    val flagResource: Int
)

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            DrapeauPaysTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    CountryList(
                        countries = getCountries(),
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

// 2. Composant pour un élément de la liste (CountryItem)
@Composable
fun CountryItem(country: Country) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp),
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp),
        shape = RoundedCornerShape(8.dp)
    ) {
        Row(
            modifier = Modifier
                .padding(16.dp)
                .fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            // Image du drapeau à gauche
            Image(
                painter = painterResource(id = country.flagResource),
                contentDescription = "Drapeau de ${country.name}",
                modifier = Modifier
                    .size(60.dp)
                    .clip(RoundedCornerShape(4.dp)),
                contentScale = ContentScale.Crop
            )

            Spacer(modifier = Modifier.width(16.dp))

            // Textes à droite
            Column {
                Text(
                    text = country.name,
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold
                )
                Text(
                    text = "Capitale : ${country.capital}",
                    style = MaterialTheme.typography.bodyMedium,
                    color = MaterialTheme.colorScheme.secondary
                )
                Text(
                    text = "Code : ${country.code}",
                    style = MaterialTheme.typography.labelSmall
                )
            }
        }
    }
}

// 3. Composant pour la liste défilable (LazyColumn)
@Composable
fun CountryList(countries: List<Country>, modifier: Modifier = Modifier) {
    LazyColumn(modifier = modifier.fillMaxSize()) {
        items(countries) { country ->
            CountryItem(country = country)
        }
    }
}

// Liste de données (plus de 5 pays avec vos images)
fun getCountries(): List<Country> {
    return listOf(
        Country("République démocratique du Congo", "Kinshasa", "CD", R.drawable.congo_drc),
        Country("France", "Paris", "FR", R.drawable.france),
        Country("Canada", "Ottawa", "CA", R.drawable.canada),
        Country("États-Unis", "Washington D.C.", "US", R.drawable.usa),
        Country("Espagne", "Madrid", "ES", R.drawable.espagne),
        Country("Chili", "Santiago", "CL", R.drawable.chili),
        Country("Népal", "Katmandou", "NP", R.drawable.nepal),
        Country("Venezuela", "Caracas", "VE", R.drawable.venezuela),
        Country("Royaume-Uni", "Londres", "GB", R.drawable.britanique)
    )
}

// 4. Prévisualisation de l'interface
@Preview(showBackground = true)
@Composable
fun PreviewCountryList() {
    DrapeauPaysTheme {
        CountryList(countries = getCountries())
    }
}
