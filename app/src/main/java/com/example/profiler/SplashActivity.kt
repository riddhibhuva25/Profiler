package com.example.profiler

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import com.example.profiler.databinding.ActivitySplashBinding
import com.google.firebase.auth.FirebaseAuth

class SplashActivity : AppCompatActivity() {
    private lateinit var binding:ActivitySplashBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySplashBinding.inflate(layoutInflater)
        setContentView(binding.root)
        window.statusBarColor = this.resources.getColor(R.color.cream)
        Handler(Looper.getMainLooper()).postDelayed({

            var intent = Intent()
            if(FirebaseAuth.getInstance().currentUser != null)
            {
                intent = Intent(this, MainActivity::class.java)
            }
            else
            {
                intent = Intent(this, IntroductionActivity::class.java)
            }


            startActivity(intent)
            //Toast.makeText(this,"111", Toast.LENGTH_SHORT).show()
            finish()
        }, 3000) // 3000 is the delayed time in milliseconds.
    }
}