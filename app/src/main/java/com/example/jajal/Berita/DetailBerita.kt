package com.example.jajal.Berita

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.bumptech.glide.Glide
import com.example.jajal.R
import kotlinx.android.synthetic.main.activity_detail_berita.*

class DetailBerita : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_berita)
        supportActionBar?.setDisplayShowHomeEnabled(true)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        // membuat get dan post

        //TODO membuat get intent
        val judulPostBerita = intent.getStringExtra("judulPost")
        val isiPostBerita = intent.getStringExtra("isiPost")
        val gambarPostBerita = intent.getIntExtra("gambarPost",0)

        //TODO menampilkan datanya
        tv_judul.text = judulPostBerita
        tv_penjelasan.text = isiPostBerita
        Glide.with(this).load(gambarPostBerita).into(iv_gambar)
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }
}
