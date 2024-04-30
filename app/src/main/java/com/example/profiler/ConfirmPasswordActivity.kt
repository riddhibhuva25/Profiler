package com.example.profiler

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.profiler.databinding.ActivityConfirmPasswprdBinding

class ConfirmPasswordActivity : AppCompatActivity() {
    private lateinit var binding:ActivityConfirmPasswprdBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityConfirmPasswprdBinding.inflate(layoutInflater)
        setContentView(binding.root)

        window.statusBarColor = this.resources.getColor(R.color.ashGray)

        initialization()
    }

    private fun initialization() {
        binding.imgBack.setOnClickListener {
            onBackPressed()
        }
        binding.btnResetPassword.setOnClickListener {
            startActivity(
                Intent(this,LoginActivity::class.java)
            )
        }
    }
}