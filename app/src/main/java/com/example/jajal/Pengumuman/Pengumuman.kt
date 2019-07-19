package com.example.jajal.Pengumuman

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import com.example.jajal.R
import kotlinx.android.synthetic.main.activity_pengumuman.*
import org.jetbrains.anko.startActivity

class Pengumuman : AppCompatActivity() {
    val items: MutableList<PostPengumuman> = mutableListOf()/*Gunanya untuk bisa mengubah ubah datanya*/

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pengumuman)
        supportActionBar?.setDisplayShowHomeEnabled(true)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        val nama = resources.getStringArray(R.array.listpostpengumuman)
        val tgl = resources.getStringArray(R.array.listtglpostpengumuman)
        val detail = resources.getStringArray(R.array.isidetailpostpengumuman)
        val gambar = resources.obtainTypedArray(R.array.gambarpostpengumuman)

        for (i in nama.indices) {
            items.add(PostPengumuman(nama[i], tgl[i], detail[i], gambar.getResourceId(i, 0)))
        }

        myRecycleview.layoutManager = LinearLayoutManager(this)
        myRecycleview.adapter = PengumumanAdapter(this, items) {
            //membuat perpindahan
            startActivity<DetailPengumuman>("judulPost" to it.judul, "isiPost" to it.isi, "gambarPost" to it.gambar)
        }
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }
}

