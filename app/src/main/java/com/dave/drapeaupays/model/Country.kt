package com.dave.drapeaupays.model

/**
 * Modèle de données pour un Pays.
 */
data class Country(
    val name: String,
    val capital: String,
    val code: String,
    val flagResource: Int
)
