package com.example.jajal

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.support.design.widget.FloatingActionButton
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.my_toolbar.*

class Post : AppCompatActivity() {
    lateinit var tv_title:TextView
    lateinit var tv_detail:TextView
    lateinit var iv_gmbr:ImageView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_post)
        supportActionBar?.setDisplayShowHomeEnabled(true)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        iv_gmbr=findViewById(R.id.iv_gambar) as ImageView
        tv_title=findViewById(R.id.tv_judul)
        tv_detail=findViewById(R.id.tv_penjelasan)

        val gambar = intent.getIntExtra("Gambar",0  )
        Glide.with(this).load(gambar).into(iv_gmbr)
        val judul = intent.getStringExtra("Judul")
        tv_title.text = judul
        val detail = intent.getStringExtra("Detail")
        tv_detail.text = detail




    }
    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }

}
