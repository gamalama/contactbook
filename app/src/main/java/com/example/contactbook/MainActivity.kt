package com.example.contactbook

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.contactbook.databinding.ActivityMainBinding

import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        val adapter = FragmentStateAdapter(this)
        binding.viewPager.adapter = adapter
        TabLayoutMediator(binding.tabLayout, binding.viewPager) { tab, position ->
            tab.text = when (position) {
                0 -> "PHONE BOOK"
                1 -> "FAVORITES"
                2 -> "ADD CONTACT"
                else -> ""
            }
        }.attach()

        binding.tabLayout.getTabAt(0)!!.setIcon(R.drawable.ic_contacts)
        binding.tabLayout.getTabAt(1)!!.setIcon(R.drawable.ic_favorite)
        binding.tabLayout.getTabAt(2)!!.setIcon(R.drawable.ic_phone)

        binding.tabLayout.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener {
            override fun onTabSelected(tab: TabLayout.Tab?) {

            }

            override fun onTabUnselected(tab: TabLayout.Tab?) {

            }

            override fun onTabReselected(tab: TabLayout.Tab?) {

            }

        })
    }
}