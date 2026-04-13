package com.dave.drapeaupays.model

import com.google.gson.annotations.SerializedName

/**
 * Modèle de données pour l'API RestCountries.
 */
data class Country(
    @SerializedName("name") val nameData: NameData,
    @SerializedName("capital") val capital: List<String>?,
    @SerializedName("cca2") val code: String,
    @SerializedName("flags") val flags: FlagsData,
    @SerializedName("region") val region: String
) {
    val commonName: String get() = nameData.common
    val mainCapital: String get() = capital?.firstOrNull() ?: "N/A"
    val flagUrl: String get() = flags.png
}

data class NameData(
    @SerializedName("common") val common: String
)

data class FlagsData(
    @SerializedName("png") val png: String
)
