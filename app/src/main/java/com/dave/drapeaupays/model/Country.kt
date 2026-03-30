package com.dave.drapeaupays.model

import androidx.annotation.DrawableRes

/**
 * Modèle de données complet pour un Pays.
 */
data class Country(
    val name: String,
    val capital: String,
    val code: String,
    @DrawableRes val flagResource: Int,
    val description: String
)
