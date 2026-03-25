package com.dave.drapeaupays.data

import com.dave.drapeaupays.R
import com.dave.drapeaupays.model.Country

/**
 * 2. Classe DataSource pour fournir les données des pays.
 */
class DataSource {
    fun loadCountries(): List<Country> {
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
}
