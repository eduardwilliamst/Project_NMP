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
import com.example.project_nmp.R
import com.example.project_nmp.User
import com.example.project_nmp.UserAdapter
import org.json.JSONObject
import java.text.SimpleDateFormat
import java.util.Locale

class UsersFragment : Fragment(R.layout.fragment_users) {

    private var recycler: RecyclerView? = null

    var users: ArrayList<User> = ArrayList()
    private val adapter = UserAdapter()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val view = inflater.inflate(R.layout.fragment_users, container, false)

        val q = Volley.newRequestQueue(activity)
        val url = "https://ubaya.me/native/160423902/getUser.php"
        var stringRequest = StringRequest(
            Request.Method.POST, url,
            Response.Listener<String> {
                Log.d("apiresultUser", it)
                val obj = JSONObject(it)
                if(obj.getString("result") == "OK") {
                    val dataArray = obj.getJSONArray("data")

                    val dateFormatter = SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.getDefault())

                    for (i in 0 until dataArray.length()) {
                        val userObj = dataArray.getJSONObject(i)
                        val dateString = userObj.getString("dateJoined")
                        val dateJoined = dateFormatter.parse(dateString)

                        val user = User(
                            username = userObj.getString("username"),
                            email = userObj.getString("email"),
                            urlProfilePicture = userObj.optString("profile_picture_url"), // Use optString to handle null case
                            password = userObj.getString("password"),
                            dateJoined = dateJoined, // Assign parsed Date object
                            totalLikes = userObj.getString("totalLikes").toInt() // Convert totalLikes string to Int
                        )
                        users.add(user)
                        Log.d("masuk ${user}", it)
                    }

                    recycler = view.findViewById(R.id.recyclerViewUsers)

                    recycler?.layoutManager = LinearLayoutManager(requireContext())
                    recycler?.adapter = this.adapter


                    this.adapter.updateData(users)
                    Log.d("cekisiarray", users.toString())
                }
            },
            Response.ErrorListener {
                Log.e("apiresult", it.message.toString())
            })
        q.add(stringRequest)

        return view
    }
}