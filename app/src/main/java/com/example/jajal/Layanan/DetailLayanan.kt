package com.example.jajal.Layanan

import android.content.Intent
import android.content.res.TypedArray
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.widget.ImageView
import com.bumptech.glide.Glide
import com.example.jajal.R
import com.synnapps.carouselview.CarouselView
import com.synnapps.carouselview.ImageListener
import kotlinx.android.synthetic.main.activity_detail_layanan.*
import kotlinx.android.synthetic.main.activity_detail_potensi.*
import kotlinx.android.synthetic.main.activity_potensi.*
import kotlinx.android.synthetic.main.list_layanan.*
import java.util.*


class DetailLayanan : AppCompatActivity() {

    val items: MutableList<Jenis> = mutableListOf()
    private var listjenis: Array<String>? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_layanan)
        supportActionBar?.setDisplayShowHomeEnabled(true)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

//        var list : Array<String> = arrayOf()
//        list = resources.getStringArray(R.array.gambardaerah)


        val position = intent.getIntExtra("position", 0)


        when (position) {
            0 -> {
                listjenis = resources.getStringArray(R.array.listjenislay1)
            }
            1 -> {
                listjenis = resources.getStringArray(R.array.listjenislay2)
            }
            2 -> {
                listjenis = resources.getStringArray(R.array.listjenislay3)
            }
            3 -> {
                listjenis = resources.getStringArray(R.array.listjenislay4)
            }
            4 -> {
                listjenis = resources.getStringArray(R.array.listjenislay5)
            }
            5 -> {
                listjenis = resources.getStringArray(R.array.listjenislay6)
            }
            6 -> {
                listjenis = resources.getStringArray(R.array.listjenislay7)
            }
            7 -> {
                listjenis = resources.getStringArray(R.array.listjenislay8)
            }
            8 -> {
                listjenis = resources.getStringArray(R.array.listjenislay9)
            }
            9 -> {
                listjenis = resources.getStringArray(R.array.listjenislay10)
            }
            10 -> {
                listjenis = resources.getStringArray(R.array.listjenislay11)
            }
            11 -> {
                listjenis = resources.getStringArray(R.array.listjenislay12)
            }
            12 -> {
                listjenis = resources.getStringArray(R.array.listjenislay13)
            }
            13 -> {
                listjenis = resources.getStringArray(R.array.listjenislay14)
            }
            14 -> {
                listjenis = resources.getStringArray(R.array.listjenislay15)
            }
            15 -> {
                listjenis = resources.getStringArray(R.array.listjenislay16)
            }
            16 -> {
                listjenis = resources.getStringArray(R.array.listjenislay17)
            }
            17 -> {
                listjenis = resources.getStringArray(R.array.listjenislay18)
            }

        }

        for (i in listjenis?.indices!!) {
            items.add(Jenis(listjenis?.get(i)))
        }

        myRecycleview1.layoutManager = LinearLayoutManager(this)
        myRecycleview1.adapter = LayananAdapter(this, items) { it, it1 ->
            finish()
        }
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }
}
