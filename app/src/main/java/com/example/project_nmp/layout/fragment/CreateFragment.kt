package com.example.project_nmp.layout.fragment

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.ArrayAdapter
import android.widget.EditText
import android.widget.Spinner
import androidx.appcompat.widget.AppCompatButton
import androidx.fragment.app.Fragment
import com.example.project_nmp.Global
import com.example.project_nmp.R

class CreateFragment : Fragment(R.layout.fragment_create) {

    private var buttonCreate: AppCompatButton? = null

    companion object {
        public const val PREFS_NAME = "MyPrefs"
        fun saveData(context: Context, cerbungTitle: String, cerbungDescription: String, cerbungImageCover: String, selectedGenre: String) {
            val sharedPreferences = context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE)
            val editor = sharedPreferences.edit()
            editor.putString("cerbungTitle", cerbungTitle)
            editor.putString("cerbungDescription", cerbungDescription)
            editor.putString("cerbungImageCover", cerbungImageCover)
            editor.putString("selectedGenre", selectedGenre)
            editor.apply()
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        buttonCreate = view.findViewById(R.id.buttonCreate)

        buttonCreate?.setOnClickListener{
            startActivity(Intent(requireContext(), FragmentActivity::class.java))
        }
    }
}
