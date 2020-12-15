package com.example.destinations_gallery_single

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.destinations_gallery_single.adapter.ItemAdapter
import com.example.destinations_gallery_single.data.Datasource
import com.google.android.material.appbar.MaterialToolbar

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val mActionBarToolbar: MaterialToolbar = findViewById(R.id.my_toolbar);
        setSupportActionBar(mActionBarToolbar);
        supportActionBar?.title = this.resources.getString(R.string.app_name);

        // Initialize data.
        val myDataset = Datasource().loadDestinations()

        val recyclerView: RecyclerView = findViewById(R.id.recycler_view)
        recyclerView.adapter = ItemAdapter(this, myDataset)

        // Use this setting to improve performance if you know that changes
        // in content do not change the layout size of the RecyclerView
        recyclerView.setHasFixedSize(true)


    }
}