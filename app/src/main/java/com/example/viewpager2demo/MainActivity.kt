package com.example.viewpager2demo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.widget.Toast
import com.example.viewpager2demo.databinding.ActivityMainBinding
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator

class MainActivity : AppCompatActivity() {
    private lateinit var binding:ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val images = listOf(R.drawable.car1,
                            R.drawable.car2,
                            R.drawable.car3,
                            R.drawable.car4,
                            R.drawable.car5)

        val adapter = ViewPagerAdapter(images)
        binding.viewpager.adapter = adapter

        TabLayoutMediator(binding.tabLayout,binding.viewpager){tab,position ->
            tab.text = "Car ${position+1}"
        }.attach() // Attaching tab layout with our viewpager

        binding.tabLayout.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener{
            override fun onTabSelected(tab: TabLayout.Tab?) {
                Toast.makeText(this@MainActivity,"Selected ${tab?.text}",Toast.LENGTH_SHORT).show()
            }

            override fun onTabUnselected(tab: TabLayout.Tab?) {
                Toast.makeText(this@MainActivity,"UnSelected ${tab?.text}",Toast.LENGTH_SHORT).show()
            }

            override fun onTabReselected(tab: TabLayout.Tab?) {
                Toast.makeText(this@MainActivity,"ReSelected ${tab?.text}",Toast.LENGTH_SHORT).show()
            }

        })

    }
}