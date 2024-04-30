package com.example.profiler

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.profiler.databinding.ActivityLoginBinding
import com.google.firebase.auth.FirebaseAuth

class LoginActivity : AppCompatActivity() {
    private lateinit var binding:ActivityLoginBinding

    private var isAllFieldsChecked = false
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)
        window.statusBarColor = this.resources.getColor(R.color.cream)

        binding.btnLogin.setOnClickListener {


            isAllFieldsChecked = checkAllFields()


            if (isAllFieldsChecked) {

                val firebaseAuth = FirebaseAuth.getInstance()

                firebaseAuth.signInWithEmailAndPassword(
                    binding.edtEmail.text.toString(),
                    binding.edtPassword.text.toString()
                )
                    .addOnSuccessListener {
                        Toast.makeText(this,"Success",Toast.LENGTH_SHORT).show()
                        val i = Intent(this, MainActivity::class.java)
                        startActivity(i)
                    }.addOnFailureListener {
                        Toast.makeText(this,"cancel",Toast.LENGTH_SHORT).show()
                        it.localizedMessage?.let { it1 -> Log.d("tag123", it1) }
                        Log.d("tag123", binding.edtEmail.toString())
                    }

            }
//            startActivity(
//                Intent(this,MainActivity::class.java)
//            )
        }
    }



    private fun checkAllFields(): Boolean {

        if (binding.edtEmail.length() == 0) {
            binding.edtEmail.error = "Email is required"
            Toast.makeText(this,"Please enter your email id",Toast.LENGTH_SHORT).show()
            return false
        }
        if (binding.edtPassword.length() == 0) {
            binding.edtPassword.error = "Password is required"
            Toast.makeText(this,"Please enter your password",Toast.LENGTH_SHORT).show()
            return false
        } else if (binding.edtPassword.length() < 8) {
            binding.edtPassword.error = "Password must be minimum 8 characters"
            Toast.makeText(this,"Please enter your 8 digit password",Toast.LENGTH_SHORT).show()
            return false
        }

        // after all validation return true.
        return true
    }
}