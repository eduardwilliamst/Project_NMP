package com.example.project_nmp.layout.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.example.project_nmp.Cerbung
import com.example.project_nmp.Global
import com.example.project_nmp.R
import com.example.project_nmp.User
import com.example.project_nmp.layout.MainActivity
import com.squareup.picasso.Picasso
import org.json.JSONObject

class DetailActivity : AppCompatActivity() {

    var cerbung: ArrayList<Cerbung> = arrayListOf()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        val cerbungId = intent.getIntExtra("id", -1)

        Toast.makeText(this, "Welcome, ${cerbungId}.", Toast.LENGTH_SHORT).show()
        val detailImage = findViewById<ImageView>(R.id.detailImage)
        val detailTitle = findViewById<TextView>(R.id.detailTitle)
        val detailParagraphs = findViewById<TextView>(R.id.detailParagraphs)
        val detailLike = findViewById<TextView>(R.id.detailLike)
        val detailFirstParagraph = findViewById<TextView>(R.id.detailFirstParagraph)

        val queue = Volley.newRequestQueue(this)
        val url = "https://ubaya.me/native/160423902/detailCerbung.php"

        val stringRequest = object : StringRequest(
            Request.Method.POST,
            url,
            Response.Listener {
                Log.d("DetailCerbung", it)
                val obj = JSONObject(it)
//                val cerbungData = obj.getJSONObject("data") // Mengambil objek user

//                Log.d("DetailCerbung", obj.toString())
                Picasso.get().load(obj.getString("imageCover")).into(detailImage)
                detailTitle.text = obj.getString("title")
                detailParagraphs.text = obj.getInt("paragraphs").toString()
                detailLike.text = obj.getInt("likes").toString()
                detailFirstParagraph.text = obj.getString("firstparagraphs")


            },
            Response.ErrorListener {
                Log.e("DetailError", it.toString())
            }
        ) {
            override fun getParams(): MutableMap<String, String> {

                val params = HashMap<String, String>()
                params.put("id", cerbungId.toString())
                return params
            }
        }
        queue.add(stringRequest)

    }
}

