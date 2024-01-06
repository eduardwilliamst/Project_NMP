package com.example.project_nmp.layout.login

import android.content.DialogInterface
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.widget.AppCompatButton
import androidx.appcompat.widget.AppCompatEditText
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.example.project_nmp.R
import org.json.JSONObject

class SignUpActivity : AppCompatActivity() {

    private var btnSubmit: AppCompatButton? = null
    private var txtEditUsername: AppCompatEditText? = null
    private var txtEditPassword: AppCompatEditText? = null
    private var txtEditConfirmPass: AppCompatEditText? = null
    private var txtEditEmail: AppCompatEditText? = null
    private var txtEditUrl: AppCompatEditText? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up)

        btnSubmit = findViewById(R.id.btn_submit_register)

        txtEditUsername = findViewById(R.id.inputTextUsername)
        txtEditEmail = findViewById(R.id.inputTextEmail)
        txtEditPassword = findViewById(R.id.inputTextPassword)
        txtEditConfirmPass = findViewById(R.id.inputTextConfirmPassword)
        txtEditUrl = findViewById(R.id.inputTextProfilePicture)

        btnSubmit?.setOnClickListener {
//            Toast.makeText(this, "Berhasil Menyimpan", Toast.LENGTH_SHORT).show()
//            startActivity(Intent(this, SignInActivity::class.java))

            val builder = AlertDialog.Builder(this)
            val q = Volley.newRequestQueue(this)
            val url = "https://ubaya.me/native/160423902/register_user.php"

            if(txtEditUsername?.text.toString().length > 0 &&
                txtEditEmail?.text.toString().length > 0 &&
                txtEditPassword?.text.toString().length > 0 &&
                txtEditUrl?.text.toString().length > 0)
            {
                if(txtEditPassword?.text.toString().equals(txtEditConfirmPass?.text.toString()))
                {
                    val username = txtEditUsername?.text.toString()
                    val password = txtEditPassword?.text.toString()
                    val urlProfile = txtEditUrl?.text.toString()
                    val email = txtEditEmail?.text.toString()

                    val stringRequest = object : StringRequest(
                        Method.POST, url,
                        {
                            val data = JSONObject(it)
                            if(data.getString("result").equals("success")){
                                Toast.makeText(this, "Success to add", Toast.LENGTH_SHORT).show()
                                startActivity(Intent(this, SignInActivity::class.java))
                                finish()
                            }
                        },
                        {
                            Toast.makeText(this, it.message.toString(), Toast.LENGTH_SHORT).show()
                        }) {
                        override fun getParams(): MutableMap<String, String> {
                            val params = HashMap<String, String>()
                            params.put("username", username)
                            params.put("password", password)
                            params.put("email", email)
                            params.put("url", urlProfile)
                            return params
                        }
                    }
                    q.add(stringRequest)
                }
                else
                {
                    builder.setTitle("Unable to Register")
                    builder.setMessage("Password did not same, Please input again")
                    builder.setNegativeButton("Ok",{ dialog: DialogInterface?, which: Int -> })
                    builder.show()
                }
            }
            else
            {
                builder.setTitle("Unable to Register")
                builder.setMessage("Please input all data")
                builder.setNegativeButton("Ok",{ dialog: DialogInterface?, which: Int -> })
                builder.show()
            }
        }
    }
}