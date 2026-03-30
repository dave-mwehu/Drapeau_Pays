package com.dave.drapeaupays.model

import androidx.annotation.DrawableRes

/**
 * Modèle de données pour un Pays, inspiré de l'architecture 'Woof'.
 */
data class Country(
    val name: String,
    @DrawableRes val flagResource: Int,
    val description: String
)
