package com.example.profiler

import android.app.Dialog
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.core.app.ShareCompat
import androidx.fragment.app.Fragment
import com.example.profiler.databinding.FragmentSettingBinding


class SettingFragment : Fragment() {
    private lateinit var binding: FragmentSettingBinding


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentSettingBinding.inflate(inflater, container, false)

        binding.txtPassword.setOnClickListener {
            startActivity(
                Intent(requireContext(),ChangePasswordActivity::class.java)
            )
        }

        binding.aboutUS.setOnClickListener {
            val intent = Intent()
            intent.action = Intent.ACTION_VIEW
            intent.addCategory(Intent.CATEGORY_BROWSABLE)
            intent.data = Uri.parse("https://www.linkedin.com/login")
            startActivity(intent)
        }

        binding.contact.setOnClickListener {
            startActivity(
                Intent(requireContext(),ContactUsActivity::class.java)
            )
        }

        binding.share.setOnClickListener {
            activity?.let { it1 ->
                ShareCompat.IntentBuilder.from(it1)
                    .setType("text/plain")
                    .setChooserTitle("Chooser title")
                    .setText("http://play.google.com/store/apps/details?id=" + requireActivity().getPackageName())
                    .startChooser()
            };
        }

        binding.logOut.setOnClickListener {
            customExitDialog()
        }
        return binding.root
    }
    fun customExitDialog() {
        // creating custom dialog
        val dialog = Dialog(requireContext())

        // setting content view to dialog
        dialog.setContentView(R.layout.custom_exit_dialog)

        // getting reference of TextView
        val dialogButtonYes = dialog.findViewById(R.id.textViewYes) as TextView
        val dialogButtonNo = dialog.findViewById(R.id.textViewNo) as TextView

        // click listener for No
        dialogButtonNo.setOnClickListener(object : View.OnClickListener {
            override fun onClick(v: View?) {
                //dismiss the dialog
                dialog.dismiss()
            }
        })

        // click listener for Yes
        dialogButtonYes.setOnClickListener(object : View.OnClickListener {
            override fun onClick(v: View?) {

                startActivity(
                    Intent(requireContext(),LoginActivity::class.java)
                )
                // dismiss the dialog
                // and exit the exit
                dialog.dismiss()

            }
        })

        // show the exit dialog
        dialog.show()
    }



}