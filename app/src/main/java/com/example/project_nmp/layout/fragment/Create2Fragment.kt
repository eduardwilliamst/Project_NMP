package com.example.project_nmp.layout.fragment

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.RadioGroup
import androidx.appcompat.widget.AppCompatButton
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.project_nmp.R

class Create2Fragment : Fragment(R.layout.fragment_create2) {

    private var buttonNext: AppCompatButton? = null
    private var buttonPrev: AppCompatButton? = null

    companion object {
        public const val PREFS_NAME = "cerbung_prefs"

        fun saveData(
            context: Context,
            accessControl: String,
            firstParagraph: String
        ) {
            val sharedPreferences = context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE)
            val editor = sharedPreferences.edit()
            editor.putString("accessControl", accessControl)
            editor.putString("firstParagraph", firstParagraph)
            editor.apply()
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        buttonNext = view.findViewById(R.id.nextButton)
        buttonPrev = view.findViewById(R.id.prevButton)

        buttonNext?.setOnClickListener {
            val radioGroup = view.findViewById<RadioGroup>(R.id.accessControlRadioGroup)
            val selectedRadioButtonId = radioGroup.checkedRadioButtonId
            var accessControl = ""

            if (selectedRadioButtonId == R.id.publicRadioButton) {
                accessControl = "Public"
            } else if (selectedRadioButtonId == R.id.privateRadioButton) {
                accessControl = "Private"
            }

            val firstParagraph = view.findViewById<EditText>(R.id.firstParagraph).text.toString()

            // Menyimpan data menggunakan SharedPreferences
            saveData(requireContext(), accessControl, firstParagraph)

            // Pindah ke Create3Activity
            findNavController().navigate(R.id.action_create2Fragment_to_create3Fragment)
        }

        buttonPrev?.setOnClickListener {
            findNavController().popBackStack()
        }
    }
}
