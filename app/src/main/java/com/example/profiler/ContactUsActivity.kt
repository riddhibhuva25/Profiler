package com.example.profiler

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.profiler.databinding.ActivityContactUsBinding

class ContactUsActivity : AppCompatActivity() {
    private lateinit var binding: ActivityContactUsBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityContactUsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnSendMessage.setOnClickListener {
            onBackPressed()
        }
    }
}