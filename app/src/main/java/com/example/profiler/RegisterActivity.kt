package com.example.profiler

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.example.profiler.databinding.ActivityLoginBinding
import com.example.profiler.databinding.ActivityRegisterBinding
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.firestore.FirebaseFirestore

class RegisterActivity : AppCompatActivity() {
    private lateinit var binding:ActivityRegisterBinding
    var isAllFieldsChecked = false

    val firebaseAuth = FirebaseAuth.getInstance()
//    private lateinit var firebaseRef:DatabaseReference
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRegisterBinding.inflate(layoutInflater)
        setContentView(binding.root)
        window.statusBarColor = this.resources.getColor(R.color.cream)

       // firebaseRef = FirebaseDatabase.getInstance().getReference("test")

        binding.btnSignup.setOnClickListener {
           /* startActivity(
                Intent(this,MainActivity::class.java)
            )*/
            val name =binding.edtName.text.toString()
            val email =binding.edtEmail.text.toString()
            val password =binding.edtPassword.text.toString()
            val age =binding.edtAge.text.toString()
            val gender =binding.edtGender.text.toString()

           /* val name = binding.edtName.text.toString()
            val email = binding.edtEmail.text.toString()
            val password = binding.edtPassword.text.toString()
*/



            firebaseAuth.createUserWithEmailAndPassword(
               email,password
            )
                .addOnSuccessListener {
                    Toast.makeText(this,"Success",Toast.LENGTH_SHORT).show()
                    saveFireStore(name,email,password,age,gender)
                    val i = Intent(this, MainActivity::class.java)
                    startActivity(i)
                }.addOnFailureListener {
                    Toast.makeText(this,"cancel",Toast.LENGTH_SHORT).show()
                    Log.d("tag123",it.localizedMessage)
                    Log.d("tag123", email.toString())
                }



            isAllFieldsChecked = CheckAllFields()


         /*   if (isAllFieldsChecked) {

//                firebaseRef.setValue("SignUp")
//                    .addOnCompleteListener{
//                        Toast.makeText(this,"Data store successfully",Toast.LENGTH_SHORT).show()
//                    }
               *//* val firebaseAuth = FirebaseAuth.getInstance()

                firebaseAuth.createUserWithEmailAndPassword(
                    binding.edtEmail.toString(),
                    binding.edtPassword.toString()
                )
                    .addOnSuccessListener {
                        Toast.makeText(this,"Success",Toast.LENGTH_SHORT).show()
                        val i = Intent(this, MainActivity::class.java)
                        startActivity(i)
                    }*//*


            }

*/
        }
    }
    fun saveFireStore(name:String,email:String,password:String,age:String,gender:String){
        val db = FirebaseFirestore.getInstance()
        val user:MutableMap<String, Any> = HashMap()

        user["name"] = name
        user["email"] =email
        user["password"] = password
        user["age"] = age
        user["gender"] = gender
        firebaseAuth.currentUser?.let {
            db.collection("users")
                .document(it.uid)
                .set(user)
                .addOnSuccessListener {
                    Toast.makeText(this,"Data Added successfully",Toast.LENGTH_SHORT).show()
                }
                .addOnFailureListener {
                    Toast.makeText(this,"Data failed",Toast.LENGTH_SHORT).show()
                    Log.d("tag00",it.localizedMessage)
                    Log.d("tag00", name.toString())
                    Log.d("tag00", email.toString())
                    Log.d("tag00", password.toString())
                    Log.d("tag00", age.toString())
                    Log.d("tag00", gender.toString())
                }
        }
       /* db.collection("users")
            .add(user)
            .addOnSuccessListener {
                Toast.makeText(this,"Data Added successfully",Toast.LENGTH_SHORT).show()
            }
            .addOnFailureListener {
                Toast.makeText(this,"Data failed",Toast.LENGTH_SHORT).show()
                Log.d("tag00",it.localizedMessage)
                Log.d("tag00", name.toString())
                Log.d("tag00", email.toString())
                Log.d("tag00", password.toString())
            }*/
    }

    private fun CheckAllFields(): Boolean {
        if (binding.edtName!!.length() == 0){
            binding.edtName!!.error = "Enter your name"
            Toast.makeText(this,"Please enter your name", Toast.LENGTH_SHORT).show()
            return false
        }

        if (binding.edtEmail!!.length() == 0) {
            binding.edtEmail!!.error = "Email is required"
            Toast.makeText(this,"Please enter your email id", Toast.LENGTH_SHORT).show()
            return false
        }
        if (binding.edtPassword!!.length() == 0) {
            binding.edtPassword!!.error = "Password is required"
            Toast.makeText(this,"Please enter your password", Toast.LENGTH_SHORT).show()
            return false
        } else if (binding.edtPassword!!.length() < 8) {
            binding.edtPassword!!.error = "Password must be minimum 8 characters"
            Toast.makeText(this,"Please enter your 8 digit password", Toast.LENGTH_SHORT).show()
            return false
        }

        // after all validation return true.
        return true
    }
}