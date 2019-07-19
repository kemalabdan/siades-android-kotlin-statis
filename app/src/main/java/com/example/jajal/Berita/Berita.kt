package com.example.jajal.Berita

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import com.example.jajal.R
import kotlinx.android.synthetic.main.activity_berita.*
import org.jetbrains.anko.startActivity

class Berita : AppCompatActivity() {
    val items : MutableList<PostBerita> = mutableListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_berita)
        supportActionBar?.setDisplayShowHomeEnabled(true)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        val nama = resources.getStringArray(R.array.listpost)
        val tgl = resources.getStringArray(R.array.listtglpost)
        val detail = resources.getStringArray(R.array.isidetailpost)
        val gambar = resources.obtainTypedArray(R.array.gambarpost)

        for (i in nama.indices){
            items.add(PostBerita(nama[i], tgl[i], detail[i], gambar.getResourceId(i, 0)))
        }

        myRecycleview.layoutManager = LinearLayoutManager(this)
        myRecycleview.adapter = BeritaAdapter(this, items){
            //membuat perpindahan
            startActivity<DetailBerita>("judulPost" to it.judul, "isiPost" to it.isi,"gambarPost" to it.gambar )
        }
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }



}
