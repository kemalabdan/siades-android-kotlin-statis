package com.example.jajal.Lainnya.Lembaga

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import com.example.jajal.R
import kotlinx.android.synthetic.main.activity_berita.*
import org.jetbrains.anko.startActivity

class Lembaga : AppCompatActivity() {
    val items: MutableList<Bagian> = mutableListOf()/*Gunanya untuk bisa mengubah ubah datanya*/

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lembaga)
        supportActionBar?.setDisplayShowHomeEnabled(true)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        val nama = resources.getStringArray(R.array.listlembaga)
        val detail = resources.getStringArray(R.array.isidetaillembaga)

        for (i in nama.indices) {
            items.add(Bagian(nama[i], detail[i]))
        }

        myRecycleview.layoutManager = LinearLayoutManager(this)
        myRecycleview.adapter = LembagaAdapter(this, items) {
            //membuat perpindahan
            startActivity<DetailLembaga>(
                "judulPost" to it.judul,
                "isiPost" to  it.isi)
        }
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }
}
