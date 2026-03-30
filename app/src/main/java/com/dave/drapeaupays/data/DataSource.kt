package com.dave.drapeaupays.data

import com.dave.drapeaupays.R
import com.dave.drapeaupays.model.Country

class DataSource {
    fun loadCountries(): List<Country> {
        return listOf(
            Country("RDC", R.drawable.congo_drc, "Située en Afrique centrale, elle est connue pour sa forêt équatoriale et son fleuve Congo."),
            Country("France", R.drawable.france, "Célèbre pour sa culture, sa gastronomie, sa mode et sa tour Eiffel à Paris."),
            Country("Canada", R.drawable.canada, "Le deuxième plus grand pays du monde, connu pour son sirop d'érable et ses paysages naturels."),
            Country("USA", R.drawable.usa, "Une puissance mondiale avec une grande diversité culturelle et géographique."),
            Country("Espagne", R.drawable.espagne, "Connue pour ses plages, sa cuisine savoureuse et son architecture unique."),
            Country("Chili", R.drawable.chili, "Pays d'Amérique du Sud tout en longueur, célèbre pour ses montagnes et ses déserts."),
            Country("Népal", R.drawable.nepal, "Abrite le mont Everest, le point le plus haut de la Terre."),
            Country("Venezuela", R.drawable.venezuela, "Réputé pour ses chutes d'eau spectaculaires comme le Salto Ángel."),
            Country("Royaume-Uni", R.drawable.britanique, "Constitué de quatre nations : Angleterre, Écosse, Pays de Galles et Irlande du Nord.")
        )
    }
}
