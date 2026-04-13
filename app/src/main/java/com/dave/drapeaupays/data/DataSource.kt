package com.dave.drapeaupays.data

import com.dave.drapeaupays.model.Country
import com.dave.drapeaupays.model.FlagsData
import com.dave.drapeaupays.model.NameData

class DataSource {
    fun loadCountries(): List<Country> {
        return listOf(
            Country(
                nameData = NameData("RDC"),
                capital = listOf("Kinshasa"),
                code = "CD",
                flags = FlagsData("https://flagcdn.com/w320/cd.png"),
                region = "Afrique"
            ),
            Country(
                nameData = NameData("France"),
                capital = listOf("Paris"),
                code = "FR",
                flags = FlagsData("https://flagcdn.com/w320/fr.png"),
                region = "Europe"
            ),
            Country(
                nameData = NameData("Canada"),
                capital = listOf("Ottawa"),
                code = "CA",
                flags = FlagsData("https://flagcdn.com/w320/ca.png"),
                region = "Amériques"
            ),
            Country(
                nameData = NameData("USA"),
                capital = listOf("Washington"),
                code = "US",
                flags = FlagsData("https://flagcdn.com/w320/us.png"),
                region = "Amériques"
            ),
            Country(
                nameData = NameData("Espagne"),
                capital = listOf("Madrid"),
                code = "ES",
                flags = FlagsData("https://flagcdn.com/w320/es.png"),
                region = "Europe"
            ),
            Country(
                nameData = NameData("Chili"),
                capital = listOf("Santiago"),
                code = "CL",
                flags = FlagsData("https://flagcdn.com/w320/cl.png"),
                region = "Amériques"
            ),
            Country(
                nameData = NameData("Népal"),
                capital = listOf("Katmandou"),
                code = "NP",
                flags = FlagsData("https://flagcdn.com/w320/np.png"),
                region = "Asie"
            ),
            Country(
                nameData = NameData("Venezuela"),
                capital = listOf("Caracas"),
                code = "VE",
                flags = FlagsData("https://flagcdn.com/w320/ve.png"),
                region = "Amériques"
            ),
            Country(
                nameData = NameData("Royaume-Uni"),
                capital = listOf("Londres"),
                code = "GB",
                flags = FlagsData("https://flagcdn.com/w320/gb.png"),
                region = "Europe"
            )
        )
    }
}
