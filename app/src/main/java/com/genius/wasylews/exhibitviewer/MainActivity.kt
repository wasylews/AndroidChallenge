package com.genius.wasylews.exhibitviewer

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import com.genius.wasylews.exhibitviewer.adapter.ExhibitAdapter
import com.genius.wasylews.fileexhibitsloader.FileExhibitsLoader
import com.genius.wasylews.model.Exhibit
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private val FILE_NAME = "exhibits.json"

    lateinit var adapter: ExhibitAdapter
    lateinit var model: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setupView()

        initModel()
        model.loadData()
    }

    private fun setupView() {
        adapter = ExhibitAdapter(supportFragmentManager)
        recycler_exhibit.layoutManager = LinearLayoutManager(this)
        recycler_exhibit.adapter = adapter
    }

    private fun initModel() {
        model = ViewModelProviders.of(this).get(MainViewModel::class.java)
        model.loader = FileExhibitsLoader(this, FILE_NAME)

        val exhibitsObserver = Observer<List<Exhibit>> {
            adapter.setItems(it)
        }

        model.exhibits.observe(this, exhibitsObserver)
    }
}
