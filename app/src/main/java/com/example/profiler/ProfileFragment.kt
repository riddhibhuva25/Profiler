package com.example.profiler

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.profiler.databinding.FragmentProfileBinding
import com.example.profiler.databinding.FragmentSettingBinding
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.DocumentChange
import com.google.firebase.firestore.EventListener
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.FirebaseFirestoreException
import com.google.firebase.firestore.Query
import com.google.firebase.firestore.QuerySnapshot

class ProfileFragment : Fragment() {
    private lateinit var binding: FragmentProfileBinding

    private lateinit var db:FirebaseFirestore
    val firebaseAuth = FirebaseAuth.getInstance()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentProfileBinding.inflate(inflater, container, false)

        binding.btnUpdate.setOnClickListener {
            update()
        }

        data()
        return binding.root
    }



    fun data(){
        db = FirebaseFirestore.getInstance()
            db.collection("users").document(firebaseAuth.currentUser!!.uid).get().addOnSuccessListener {
                Log.d("Tag123",it.id.toString())
                binding.edtName.setText(it.getString("name"))
                binding.edtGender.setText(it.getString("gender"))
                binding.edtAge.setText(it.getString("age"))
                binding.edtNumber.setText(it.getString("email"))
            }

    }

    fun update(){
        db = FirebaseFirestore.getInstance()
        db.collection("users").document(firebaseAuth.currentUser!!.uid).update("name",binding.edtName.text.toString(),"gender",binding.edtGender.text.toString(),"age",binding.edtAge.text.toString(),"email",binding.edtNumber.text.toString()).addOnSuccessListener {
           /* Log.d("Tag123",it.id.toString())
            binding.edtName.setText(it.getString("name"))
            binding.edtGender.setText(it.getString("gender"))
            binding.edtAge.setText(it.getString("age"))
            binding.edtNumber.setText(it.getString("email"))*/
    }
    }


}