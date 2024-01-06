package com.example.project_nmp.layout.fragment

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.Switch
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatDelegate
import com.android.volley.Response
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.example.project_nmp.Global
import com.example.project_nmp.R
import com.example.project_nmp.layout.MainActivity
import com.example.project_nmp.layout.login.SignInActivity
import com.squareup.picasso.Picasso

class PrefsFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_prefs, container, false)

        // Mengambil referensi ke komponen dalam layout XML
        val logoutButton: Button = view.findViewById(R.id.logout_button)
        val darkModeSwitch: Switch = view.findViewById(R.id.dark_mode_switch)
        val changePasswordButton: Button = view.findViewById(R.id.change_password_button)
        val oldPasswordEditText: EditText = view.findViewById(R.id.old_password_edittext)
        val newPasswordEditText: EditText = view.findViewById(R.id.new_password_edittext)
        val retypeNewPasswordEditText: EditText = view.findViewById(R.id.retype_new_password_edittext)
        val username = view.findViewById<TextView>(R.id.username_prefs)
        val coverImage = view.findViewById<ImageView>(R.id.profile_image)

        Picasso.get().load(Global.url).into(coverImage)
        username.text = Global.username

        // Logout
        logoutButton.setOnClickListener {
             requireActivity().startActivity(Intent(requireContext(), SignInActivity::class.java))
             requireActivity().finish()
        }

        // Ganti Mode Tampilan (Light/Dark)
        darkModeSwitch.setOnCheckedChangeListener { _, isChecked ->
            val mode = if (isChecked) AppCompatDelegate.MODE_NIGHT_YES else AppCompatDelegate.MODE_NIGHT_NO
            AppCompatDelegate.setDefaultNightMode(mode)
        }

        // Ganti Password
        changePasswordButton.setOnClickListener {
            // Tambahkan logika untuk mengganti password di sini
            val oldPassword = oldPasswordEditText.text.toString()
            val newPassword = newPasswordEditText.text.toString()
            val retypeNewPassword = retypeNewPasswordEditText.text.toString()

            // Validasi inputan password di sini
            if (newPassword == retypeNewPassword) {
                val q = Volley.newRequestQueue(activity)
                val url = "https://ubaya.me/native/160423902/changePassword.php"

                val stringRequest = object : StringRequest(
                    Method.POST, url,
                    Response.Listener { response ->

                        Log.d("CekGantiPass", response)
                        Toast.makeText(requireContext(), "Password berhasil diubah", Toast.LENGTH_SHORT).show()
                    },
                    Response.ErrorListener {
                        Toast.makeText(requireContext(), "Gagal mengubah password", Toast.LENGTH_SHORT).show()
                    }
                ) {
                    override fun getParams(): Map<String, String> {
                        val params = HashMap<String, String>()
                        params["old_password"] = oldPassword
                        params["new_password"] = newPassword
                        params["email"] = Global.email
                        return params
                    }
                }

                q.add(stringRequest)
            } else {
                Toast.makeText(requireContext(), "Password baru dan konfirmasi password tidak cocok", Toast.LENGTH_SHORT).show()
            }
        }

        return view
    }
}
