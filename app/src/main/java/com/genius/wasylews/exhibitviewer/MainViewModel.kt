package com.genius.wasylews.exhibitviewer

import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import com.genius.wasylews.model.Exhibit
import com.genius.wasylews.model.ExhibitLoader

class MainViewModel: ViewModel() {

    lateinit var loader: ExhibitLoader

    val exhibits: MutableLiveData<List<Exhibit>> by lazy {
        MutableLiveData<List<Exhibit>>()
    }

    fun loadData() {
        exhibits.value = loader.getExhibitList()
    }
}