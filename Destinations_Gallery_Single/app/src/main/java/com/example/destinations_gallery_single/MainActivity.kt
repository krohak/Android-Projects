package com.example.destinations_gallery_single

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import com.example.destinations_gallery_single.adapter.ItemAdapter
import com.example.destinations_gallery_single.data.Datasource
import com.example.destinations_gallery_single.databinding.ActivityMainBinding
import com.google.android.material.appbar.MaterialToolbar


class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
//        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        setContentView(binding.root)

        val mActionBarToolbar: MaterialToolbar = binding.myToolbar;
        setSupportActionBar(mActionBarToolbar);
        supportActionBar?.title = this.resources.getString(R.string.app_name);

        // Initialize data.
        val myDataset = Datasource().loadDestinations()

        val recyclerView: RecyclerView = binding.recyclerView;
        recyclerView.adapter = ItemAdapter(this, myDataset)

        // Use this setting to improve performance if you know that changes
        // in content do not change the layout size of the RecyclerView
        recyclerView.setHasFixedSize(true)


    }
}