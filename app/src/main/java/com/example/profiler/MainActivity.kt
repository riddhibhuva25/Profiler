package com.example.profiler

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.viewpager2.widget.ViewPager2
import com.example.profiler.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding:ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        window.statusBarColor = this.resources.getColor(R.color.teaGreen)
        val viewPager: ViewPager2 = findViewById(R.id.viewPager)
        val fragments = listOf(ProfileFragment(), HomeFragment(), SettingFragment()) // Replace with your fragment instances
        val adapter = ViewPagerAdapter(fragments, this)
        viewPager.adapter = adapter

        binding.bottomNavigationView.setOnItemSelectedListener { item ->
            when(item.itemId) {
                R.id.profile -> {
                    Toast.makeText(this,"profile",Toast.LENGTH_SHORT).show()
                    viewPager.currentItem = 0


                    true
                }
                R.id.home -> {
                    Toast.makeText(this,"home",Toast.LENGTH_SHORT).show()
                    viewPager.currentItem = 1
                    true
                }

                R.id.setting-> {
                    Toast.makeText(this,"setting",Toast.LENGTH_SHORT).show()
                    viewPager.currentItem = 2
                    true
                }
                else -> false
            }
        }
    }
}