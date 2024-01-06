package com.example.project_nmp.layout.fragment

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.example.project_nmp.Cerbung
import com.example.project_nmp.CerbungAdapter
import com.example.project_nmp.Genre
import com.example.project_nmp.Global
import com.example.project_nmp.R
import com.google.android.material.button.MaterialButton
import com.google.android.material.button.MaterialButtonToggleGroup
import com.google.android.material.floatingactionbutton.FloatingActionButton
import org.json.JSONException
import org.json.JSONObject

class HomeFragment : Fragment(R.layout.fragment_home) {

    private var recycler: RecyclerView? = null

    private val adapter = CerbungAdapter()
    var genres: ArrayList<Genre> = ArrayList()
    var cerbungs: ArrayList<Cerbung> = ArrayList()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val toggleGroup = view.findViewById<MaterialButtonToggleGroup>(R.id.toggle_group)

        val q = Volley.newRequestQueue(activity)
        val url = "https://ubaya.me/native/160423902/getGenre.php"
        var stringRequest = object :  StringRequest(
            Request.Method.POST,
            url,
            Response.Listener {
                Log.d("apiresult", it)
                val obj = JSONObject(it)
                if(obj.getString("result") == "OK") {
                    val data = obj.getJSONArray("data")

                    for(i in 0 until data.length()) {
                        val playObj = data.getJSONObject(i)
                        with(playObj) {
                            val Genress = Genre(
                                getInt("id"),
                                getString("nama")
                            )
                            genres.add(Genress)
                        }
                    }
                    Log.d("genrecheck", genres.toString())
                    Global.genre = genres
                    val genresis = Global.genre
                    Log.d("genres", Global.genre.toString())
                    for (genre in genresis) {

                        val button = MaterialButton(requireContext())
                        button.id = View.generateViewId()
                        button.text = genre.toString()
                        button.layoutParams = LinearLayout.LayoutParams(
                            ViewGroup.LayoutParams.WRAP_CONTENT,
                            ViewGroup.LayoutParams.WRAP_CONTENT
                        )

                        toggleGroup.addView(button)
                    }

                    toggleGroup.check(toggleGroup.getChildAt(0).id)
                }
            },
            Response.ErrorListener {
                Log.e("apiresult", it.message.toString())
            }
        ){}
        q.add(stringRequest)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val view = inflater.inflate(R.layout.fragment_home, container, false)

        val q = Volley.newRequestQueue(activity)
        val url = "https://ubaya.me/native/160423902/getCerbung.php"
        var stringRequest = StringRequest(
            Request.Method.POST, url,
            Response.Listener<String> {
                Log.d("apiresultcerbung", it)
                val obj = JSONObject(it)
                if(obj.getString("result") == "OK") {
                    val data = obj.getJSONArray("data")

                    for(i in 0 until data.length()) {
                        val playObj = data.getJSONObject(i)
                        val cerbung = Cerbung(
                            id = playObj.getString("id").toInt(),
                            title = playObj.getString("title"),
                            genre_id = playObj.getString("genre_id").toInt(),
                            description = playObj.getString("description"),
                            imageCover = playObj.getString("imageCover"),
                            author = playObj.getString("author"),
                            likes = playObj.getString("likes").toInt(),
                            paragraphs = playObj.getString("paragraphs").toInt(),
                            accessControl = playObj.getString("accessControl"),
                            firstparagraphs = playObj.getString("firstparagraphs"),
                        )
                        cerbungs.add(cerbung)
                        Log.d("masuk", it)
                    }

                    recycler = view.findViewById(R.id.recycler_view)

                    recycler?.layoutManager = LinearLayoutManager(requireContext())
                    recycler?.adapter = this.adapter

                    this.adapter.updateData(cerbungs)

                    Log.d("cekisiarray", cerbungs.toString())
                }
            },
            Response.ErrorListener {
                Log.e("apiresult", it.message.toString())
            })
        q.add(stringRequest)

        return view
    }
}