package com.genius.wasylews.model

data class Exhibit(
    val title: String,
    val images: List<String>
)

data class ExhibitList(

    val list: List<Exhibit>
)