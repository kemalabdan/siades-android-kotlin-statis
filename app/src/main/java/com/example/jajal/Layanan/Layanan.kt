package com.example.jajal.Layanan

import android.content.ClipData
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import com.example.jajal.R
import kotlinx.android.synthetic.main.activity_berita.*
import kotlinx.android.synthetic.main.activity_main.*
import org.jetbrains.anko.linearLayout
import org.jetbrains.anko.startActivity
import org.jetbrains.anko.toast

class Layanan : AppCompatActivity() {
    val items: MutableList<Jenis> = mutableListOf()/*Gunanya untuk bisa mengubah ubah datanya*/

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_layanan)
        supportActionBar?.setDisplayShowHomeEnabled(true)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        val nama = resources.getStringArray(R.array.listlayanan)

        for (i in nama.indices) {
            items.add(Jenis(nama[i]))
        }

        myRecycleview.layoutManager = LinearLayoutManager(this)
        myRecycleview.adapter = LayananAdapter(this, items) { it, it1 ->
            //membuat perpindahan
            startActivity<DetailLayanan>(
                "judulPost" to it.judul,
                "position" to it1
            )
        }
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }
}
