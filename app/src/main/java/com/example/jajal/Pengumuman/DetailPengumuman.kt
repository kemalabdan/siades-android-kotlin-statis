package com.example.jajal.Pengumuman

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.bumptech.glide.Glide
import com.example.jajal.R
import kotlinx.android.synthetic.main.activity_detail_pengumuman.*

class DetailPengumuman : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_pengumuman)
        supportActionBar?.setDisplayShowHomeEnabled(true)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        // membuat get dan post

        //TODO membuat get intent
        val judulPostPengumuman = intent.getStringExtra("judulPost")
        val isiPostPengumuman = intent.getStringExtra("isiPost")
        val gambarPostPengumuman = intent.getIntExtra("gambarPost",0)

        //TODO menampilkan datanya
        tv_judul.text = judulPostPengumuman
        tv_penjelasan.text = isiPostPengumuman
        Glide.with(this).load(gambarPostPengumuman).into(iv_gambar)
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }
}
