package com.example.profiler

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.profiler.databinding.ActivityIntroductionBinding

class IntroductionActivity : AppCompatActivity() {
    private lateinit var binding: ActivityIntroductionBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityIntroductionBinding.inflate(layoutInflater)
        setContentView(binding.root)
        window.statusBarColor = this.resources.getColor(R.color.cream)
        binding.btnLogin.setOnClickListener {
            startActivity(
                Intent(this,LoginActivity::class.java)
            )
            finish()
        }

        binding.btnRegister.setOnClickListener {
            startActivity(
                Intent(this,RegisterActivity::class.java)
            )
            finish()
        }
    }
}