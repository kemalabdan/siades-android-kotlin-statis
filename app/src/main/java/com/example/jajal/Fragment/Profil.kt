package com.example.jajal.Fragment

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.example.jajal.R
import kotlinx.android.synthetic.main.activity_profil.*

class Profil : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        getActivity()?.setTitle("LOGIN");
        val view: View
        view = inflater.inflate(R.layout.activity_profil,null)
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
//        btnLogin.setOnClickListener {
//            val email = inputEmail.text.toString()
//            val password = inputPassword.text.toString()
//            if (email.isEmpty()|| password.isEmpty()) {
//                Toast.makeText(this, "Email dan Password harus diisi", Toast.LENGTH_SHORT).show()
//                return@setOnClickListener
//            }
//        }
    }
}
