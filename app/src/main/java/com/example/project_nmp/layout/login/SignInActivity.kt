package com.example.project_nmp.layout.login

import android.content.DialogInterface
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.widget.AppCompatButton
import androidx.appcompat.widget.AppCompatEditText
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.example.project_nmp.Global
import com.example.project_nmp.R
import com.example.project_nmp.User
import com.example.project_nmp.layout.MainActivity
import org.json.JSONObject

class SignInActivity : AppCompatActivity() {

    private var btnSignUp: AppCompatButton? = null
    private var btnSignIn: AppCompatButton? = null
    private var txtEditUsername: AppCompatEditText? = null
    private var txtEditPassword: AppCompatEditText? = null

    var user: ArrayList<User> = arrayListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_in)

        btnSignUp = findViewById(R.id.button_signup)
        btnSignIn = findViewById(R.id.button_login)

        txtEditUsername = findViewById(R.id.editTextEmail)
        txtEditPassword = findViewById(R.id.editTextPassword)

        btnSignIn?.setOnClickListener {
//            val text: String = user?.text.toString()


//            startActivity(Intent(this, MainActivity::class.java))

            val builder = AlertDialog.Builder(this)
            val queue = Volley.newRequestQueue(this)
            val url = "https://ubaya.me/native/160423902/login_user.php"

            if(txtEditUsername?.text.toString().length > 0 &&
                txtEditPassword?.text.toString().length > 0)
            {

                val username = txtEditUsername?.text.toString()
                val password = txtEditPassword?.text.toString()
//                Toast.makeText(this, "Berhasil Menyimpan ${username} dan ${password} ", Toast.LENGTH_SHORT).show()
                val stringRequest = object : StringRequest(
                    Request.Method.POST,
                    url,
                    Response.Listener {
                        Log.d("LoginCheck", it)
                        val obj = JSONObject(it)
                        if (obj.getString("result") == "success"){
                            val userData = obj.getJSONObject("user") // Mengambil objek user
                            Global.username = userData.getString("username")
                            Global.email = userData.getString("email")
                            Global.password = userData.getString("password")
                            Global.url = userData.getString("profile_picture_url")

                            Toast.makeText(this, "Welcome, ${Global.username}.", Toast.LENGTH_SHORT).show()

                            Log.d("userCheck", user.toString())
                            startActivity(Intent(this, MainActivity::class.java))
                            finish()
                        }
                    },
                    Response.ErrorListener {
                        Log.e("LoginError", it.toString())
                    }
                ) {
                    override fun getParams(): MutableMap<String, String> {

                        val params = HashMap<String, String>()
                        params.put("username", username)
                        params.put("password", password)
                        return params
                    }
                }
                queue.add(stringRequest)
                this.finishActivity(0)

            } else
            {
                builder.setTitle("Unable to Login")
                builder.setMessage("Please input all data")
                builder.setNegativeButton("Ok",{ dialog: DialogInterface?, which: Int -> })
                builder.show()
            }
        }
        btnSignUp?.setOnClickListener{
            startActivity(Intent(this, SignUpActivity::class.java))
        }
    }
}