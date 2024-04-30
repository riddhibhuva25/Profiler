package com.example.profiler

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.profiler.databinding.FragmentHomeBinding
import com.google.firebase.firestore.DocumentChange
import com.google.firebase.firestore.EventListener
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.FirebaseFirestoreException
import com.google.firebase.firestore.Query
import com.google.firebase.firestore.QuerySnapshot


class HomeFragment : Fragment() {
    private lateinit var binding: FragmentHomeBinding
    private lateinit var customAdapter: CustomAdapter
    private lateinit var db:FirebaseFirestore
    private lateinit var userArrayList:ArrayList<Model>


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentHomeBinding.inflate(inflater, container, false)
        binding.recycleHome

        val layoutManager = LinearLayoutManager(requireContext())
        binding.recycleHome.layoutManager = layoutManager

        userArrayList = arrayListOf()
       /* arraylist.add(Model("Alex",30,"Male", 9876543201.toInt()))
        arraylist.add(Model("Sinthiya",24,"Female",9825643023.toInt()))
        arraylist.add(Model("Bella",27,"Female",9825122023.toInt()))
        arraylist.add(Model("Richard",34,"Male",9789643023.toInt()))
        arraylist.add(Model("Simon",33,"Male",9780643023.toInt()))
        arraylist.add(Model("William",34,"Male",9789643023.toInt()))
        arraylist.add(Model("Rebecca",34,"Female",9789643023.toInt()))*/
        customAdapter = CustomAdapter(userArrayList)
        binding.recycleHome.adapter = customAdapter
        data()
        return binding.root
    }

    fun data(){
         db = FirebaseFirestore.getInstance()
        db.collection("users").get().addOnSuccessListener {
            val allDocuments = it.documents
            val profileArray = ArrayList<Model>()
            for (document in allDocuments)
            {
                profileArray.add(Model(document.getString("name"),document.getString("email"),document.getString("gender"),document.getString("age")))

            }
            binding.recycleHome.adapter = CustomAdapter(profileArray)
        }


    }
/*  fun getData(){
      val db = FirebaseFirestore.getInstance()
      db.collection("users")
          .get()
          .addOnCompleteListener{
              val result : StringBuffer = StringBuffer()

              if (it.isSuccessful){
                  for (document in it.result!!){
                      result.append(document.data.getValue("name")).append(" ")
                          .append(document.data.getValue("email")).append(" ")
                  }

              }
          }
  }*/

    }

