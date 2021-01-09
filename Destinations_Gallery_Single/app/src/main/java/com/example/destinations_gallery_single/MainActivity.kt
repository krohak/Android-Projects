package com.example.destinations_gallery_single

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.lifecycleScope
import androidx.navigation.findNavController
import androidx.navigation.ui.NavigationUI
import com.example.destinations_gallery_single.data.Datasource
import com.example.destinations_gallery_single.data.PageDatabase
import com.example.destinations_gallery_single.databinding.ActivityMainBinding
import com.google.android.material.appbar.MaterialToolbar
import kotlinx.coroutines.launch


class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = DataBindingUtil.setContentView<ActivityMainBinding>(
            this, R.layout.activity_main
        )
        val navController = this.findNavController(R.id.myNavHostFragment)

        val mActionBarToolbar: MaterialToolbar = binding.myToolbar
        setSupportActionBar(mActionBarToolbar)

        NavigationUI.setupActionBarWithNavController(this, navController)
        NavigationUI.setupWithNavController(binding.navView, navController)

        val myDataset = Datasource(application).loadPages()
        val pageDatabase = PageDatabase.getInstance(application)

        lifecycleScope.launch {
            pageDatabase.pageDatabaseDao.insertAll(myDataset)
        }
    }

    fun setActionBarTitle(title: String?) {
        supportActionBar?.title = title
    }
}