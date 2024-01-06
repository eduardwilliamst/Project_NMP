package com.example.project_nmp.layout.fragment

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.widget.AppCompatButton
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import androidx.navigation.fragment.findNavController
import com.android.volley.Response
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.example.project_nmp.R
import com.example.project_nmp.layout.MainActivity
import com.example.project_nmp.layout.activity.HomeActivity

class Create3Fragment : Fragment(R.layout.fragment_create3) {

    private var buttonSave: AppCompatButton? = null
    private var buttonPrev: AppCompatButton? = null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        buttonSave = view.findViewById(R.id.saveButton)
        buttonPrev = view.findViewById(R.id.prevButton)

        val create1SharedPreferences = requireContext().getSharedPreferences(Create1Fragment.PREFS_NAME, Context.MODE_PRIVATE)
        val cerbungTitle = create1SharedPreferences.getString("cerbungTitle", "") ?: ""
        val cerbungDescription = create1SharedPreferences.getString("cerbungDescription", "") ?: ""
        val cerbungImageCover = create1SharedPreferences.getString("cerbungImageCover", "") ?: ""
        val cerbungAuthor = create1SharedPreferences.getString("cerbungAuthor", "") ?: ""
        val selectedGenre = create1SharedPreferences.getString("selectedGenre", "") ?: ""

        val create2SharedPreferences = requireContext().getSharedPreferences(Create2Fragment.PREFS_NAME, Context.MODE_PRIVATE)
        val accessControl = create2SharedPreferences.getString("accessControl", "") ?: ""
        val firstParagraph = create2SharedPreferences.getString("firstParagraph", "") ?: ""

        val cerbungTitleTextView = view.findViewById<TextView>(R.id.title)
        cerbungTitleTextView.text = cerbungTitle

        val cerbungDescriptionTextView = view.findViewById<TextView>(R.id.shortDescription)
        cerbungDescriptionTextView.text = cerbungDescription

        val cerbungImageCoverTextView = view.findViewById<TextView>(R.id.imageCover)
        cerbungImageCoverTextView.text = cerbungImageCover

        val cerbungAuthorTextView = view.findViewById<TextView>(R.id.author)
        cerbungAuthorTextView.text = cerbungAuthor

        val selectedGenreTextView = view.findViewById<TextView>(R.id.genre)
        selectedGenreTextView.text = selectedGenre

        buttonSave?.setOnClickListener {
            val q = Volley.newRequestQueue(activity)
            val url = "https://ubaya.me/native/160423902/addCerbung.php"

            val stringRequest = object : StringRequest(
                Method.POST, url,
                Response.Listener { response ->
                    Log.d("InsertCerbung", response)

                    Toast.makeText(requireContext(), "Berhasil Menyimpan Data Cerbung", Toast.LENGTH_SHORT).show()
                    startActivity(Intent(requireContext(), MainActivity::class.java).apply {
                        addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP or Intent.FLAG_ACTIVITY_NEW_TASK)
                    })
                    requireActivity().finish()
                },
                Response.ErrorListener {
                    Log.e("InsertCerbung", it.message.toString() ?: "Unknown error")
                    Toast.makeText(requireContext(), "Gagal Menyimpan Data Cerbung", Toast.LENGTH_SHORT).show()
                }
            ) {
                override fun getParams(): Map<String, String> {
                    val params = HashMap<String, String>()
                    params["title"] = cerbungTitle
                    params["genre_id"] = selectedGenre
                    params["description"] = cerbungDescription
                    params["imageCover"] = cerbungImageCover
                    params["author"] = cerbungAuthor
                    params["likes"] = "0" // Default value for likes
                    params["paragraphs"] = "0" // Default value for paragraphs
                    params["accessControl"] = accessControl
                    params["firstparagraphs"] = firstParagraph
                    return params
                }
            }

            q.add(stringRequest)
        }

        buttonPrev?.setOnClickListener {
            findNavController().popBackStack()
        }
    }
}
