package com.example.profiler

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.profiler.databinding.ActivityChangePasswordBinding

class ChangePasswordActivity : AppCompatActivity() {
    private lateinit var binding: ActivityChangePasswordBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityChangePasswordBinding.inflate(layoutInflater)
        setContentView(binding.root)
        window.statusBarColor = this.resources.getColor(R.color.ashGray)
        initialization()
    }

    private fun initialization() {
        binding.btnResetPassword.setOnClickListener {
            startActivity(
                Intent(this,ConfirmPasswordActivity::class.java)
            )
            finish()
        }

        binding.imgBack.setOnClickListener {
            onBackPressed()
        }
    }
}