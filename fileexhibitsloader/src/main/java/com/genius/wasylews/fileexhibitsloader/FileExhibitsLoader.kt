package com.genius.wasylews.fileexhibitsloader

import android.content.Context
import com.genius.wasylews.model.Exhibit
import com.genius.wasylews.model.ExhibitList
import com.genius.wasylews.model.ExhibitLoader
import com.google.gson.Gson

class FileExhibitsLoader(private val context: Context,
                         private val fileName: String): ExhibitLoader {

    private val gson = Gson()

    override fun getExhibitList(): List<Exhibit> {
        val reader = context.assets
            .open(fileName)
            .bufferedReader()

        val json = reader.use { it.readText() }
        return gson.fromJson(json, ExhibitList::class.java).list
    }
}