package com.example.project_nmp.layout.fragment

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.ArrayAdapter
import android.widget.EditText
import android.widget.Spinner
import android.widget.Toast
import androidx.appcompat.widget.AppCompatButton
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.project_nmp.Global
import com.example.project_nmp.R

class Create1Fragment : Fragment(R.layout.fragment_create1) {

    private var buttonNext: AppCompatButton? = null
    private lateinit var cerbungGenreSpinner: Spinner

    companion object {
        public const val PREFS_NAME = "MyPrefs"
        fun saveData(context: Context, cerbungTitle: String, cerbungDescription: String, cerbungImageCover: String, cerbungAuthor: String, selectedGenre: String) {
            val sharedPreferences = context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE)
            val editor = sharedPreferences.edit()
            editor.putString("cerbungTitle", cerbungTitle)
            editor.putString("cerbungDescription", cerbungDescription)
            editor.putString("cerbungImageCover", cerbungImageCover)
            editor.putString("cerbungAuthor", cerbungAuthor)
            editor.putString("selectedGenre", selectedGenre)
            editor.apply()
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        buttonNext = view.findViewById(R.id.nextButton)
        cerbungGenreSpinner = view.findViewById(R.id.cerbungGenreSpinner)

        val adapter = ArrayAdapter(requireContext(), R.layout.simple_list_item_1, Global.genre)
        adapter.setDropDownViewResource(R.layout.simple_spinner_dropdown_item)
        cerbungGenreSpinner.adapter = adapter

        buttonNext?.setOnClickListener{
            // Mengambil data dari input pengguna
            val cerbungTitle = view.findViewById<EditText>(R.id.cerbungTitle).text.toString()
            val cerbungDescription = view.findViewById<EditText>(R.id.cerbungDescription).text.toString()
            val cerbungImageCover = view.findViewById<EditText>(R.id.cerbungImageCover).text.toString()
            val cerbungAuthor = view.findViewById<EditText>(R.id.cerbungAuthor).text.toString()
            val selectedGenre = cerbungGenreSpinner.selectedItem.toString()

            // Menyimpan data menggunakan SharedPreferences
            saveData(requireContext(), cerbungTitle, cerbungDescription, cerbungImageCover, cerbungAuthor, selectedGenre)

            // Pindah ke Create2Activity
            findNavController().navigate(R.id.action_create1Fragment_to_create2Fragment)

//            Toast.makeText(this, "Berhasil Menyimpan ${Global.genre}", Toast.LENGTH_SHORT).show()
        }
    }
}
