package com.example.jajal.Fragment.Lainnya.Lembaga

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.bumptech.glide.Glide
import com.example.jajal.R
import kotlinx.android.synthetic.main.activity_detail_berita.*
import kotlinx.android.synthetic.main.activity_detail_lembaga.*

class DetailLembaga : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_lembaga)
        supportActionBar?.setDisplayShowHomeEnabled(true)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        // membuat get dan post

        //TODO membuat get intent
        val judulPostLembaga = intent.getStringExtra("judulPost")
        val isiPostLembaga = intent.getStringExtra("isiPost")

        //TODO menampilkan datanya
        tv_judul_lem.text = judulPostLembaga
        tv_penjelasan_lem.text = isiPostLembaga
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }
}
