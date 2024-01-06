package com.example.project_nmp.layout.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.example.project_nmp.Global
import com.example.project_nmp.R
import com.squareup.picasso.Picasso
import org.json.JSONObject

class DetailUserActivity : AppCompatActivity() {

    lateinit var imageViewAvatarDetail: ImageView
    lateinit var textViewUsernameDetail: TextView
    lateinit var textViewTotalLikesDetail: TextView
    lateinit var textViewCerbungCountDetail: TextView
    lateinit var textViewLatestPostDateDetail: TextView
    lateinit var buttonSeeCerbungs: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_user)

        imageViewAvatarDetail = findViewById(R.id.imageViewAvatarDetail)
        textViewUsernameDetail = findViewById(R.id.textViewUsernameDetail)
        textViewTotalLikesDetail = findViewById(R.id.textViewTotalLikesDetail)
        textViewCerbungCountDetail = findViewById(R.id.textViewCerbungCountDetail)
        textViewLatestPostDateDetail = findViewById(R.id.textViewLatestPostDateDetail)
        buttonSeeCerbungs = findViewById(R.id.buttonSeeCerbungs)

        val username = intent.getStringExtra("username")

        Toast.makeText(this, "Welcome, ${username}.", Toast.LENGTH_SHORT).show()
        val queue = Volley.newRequestQueue(this)
        val url = "https://ubaya.me/native/160423902/detailUser.php"

        val stringRequest = object : StringRequest(
            Request.Method.POST,
            url,
            Response.Listener {
                Log.d("DetailUser", it)
                val obj = JSONObject(it)

                Picasso.get().load(obj.getString("profile_picture_url")).into(imageViewAvatarDetail)
                textViewUsernameDetail.text = obj.getString("username")
                textViewTotalLikesDetail.text = "Total Likes: ${obj.getInt("totalLikes")}"
                textViewCerbungCountDetail.text = "Cerbung Count: ${obj.getInt("cerbungCount")}"
                textViewLatestPostDateDetail.text = "Latest Post Date: ${obj.getString("latestPostDate")}"

                buttonSeeCerbungs.setOnClickListener {

                }
            },
            Response.ErrorListener {
                Log.e("DetailError", it.toString())
            }
        ) {
            override fun getParams(): MutableMap<String, String> {
                val params = HashMap<String, String>()
                params["username"] = username.toString()
                return params
            }
        }
        queue.add(stringRequest)
    }
}
