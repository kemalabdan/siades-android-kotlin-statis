package com.example.jajal

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_pengaduan.*
import kotlinx.android.synthetic.main.activity_profil.*

class Pengaduan : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pengaduan)
        supportActionBar?.setDisplayShowHomeEnabled(true)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        btnKirim.setOnClickListener {
            val aduan = inputPengaduan.text.toString()
            if (aduan.isEmpty()) {
                Toast.makeText(this, "Kolom Pengaduan harus diisi", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }
            val intent = Intent (this,Pengaduan::class.java)
            startActivity(intent)
            finish()
        }
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }
}
