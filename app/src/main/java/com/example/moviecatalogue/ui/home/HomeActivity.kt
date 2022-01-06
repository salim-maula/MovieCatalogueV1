package com.example.moviecatalogue.ui.home

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.moviecatalogue.databinding.ActivityHomeBinding

class HomeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val activityHomeBinding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(activityHomeBinding.root)
        supportActionBar?.hide()

        val sectionPagerAdapter = SectionPagerAdapter(this, supportFragmentManager)
        activityHomeBinding.viewpager.adapter = sectionPagerAdapter
        activityHomeBinding.viewpagertab.setViewPager(activityHomeBinding.viewpager)
    }
}