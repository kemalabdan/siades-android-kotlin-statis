package com.example.jajal.Potensi

import android.content.Intent
import android.content.res.TypedArray
import android.net.Uri
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.ImageView
import com.bumptech.glide.Glide
import com.example.jajal.R
import com.synnapps.carouselview.CarouselView
import com.synnapps.carouselview.ImageListener
import kotlinx.android.synthetic.main.activity_detail_potensi.*
import kotlinx.android.synthetic.main.activity_potensi.*
import org.jetbrains.anko.sdk25.coroutines.onClick
import java.util.*


class DetailPotensi : AppCompatActivity() {

    lateinit var carouselView: CarouselView
    private var gambar: TypedArray? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_potensi)
        supportActionBar?.setDisplayShowHomeEnabled(true)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)


        val namaDaerah = intent.getStringExtra("JUDUL")
        val isiDaerah = intent.getStringExtra("DETAIL")
        val urll = intent.getStringExtra("URL")
        val position = intent.getIntExtra("position", 0)


        when (position) {
            0 -> {
                gambar = resources.obtainTypedArray(R.array.gambarmonggang)
            }
            1 -> {
                gambar = resources.obtainTypedArray(R.array.gambarkrandohan)
            }
            2 -> {
                gambar = resources.obtainTypedArray(R.array.gambarkaliputih)
            }
            3 -> {
                gambar = resources.obtainTypedArray(R.array.gambarbanyon)
            }
            4 -> {
                gambar = resources.obtainTypedArray(R.array.gambardagen)
            }
            5 -> {
                gambar = resources.obtainTypedArray(R.array.gambardiro)
            }
        }

        carouselView = findViewById(R.id.carouselView)
        carouselView.setPageCount(3)
        carouselView.setImageListener(imageListener)

        tv_judul.text = namaDaerah
        tv_penjelasan.text = isiDaerah
        fab.onClick {
            val intent = Intent(
                Intent.ACTION_VIEW,
                Uri.parse(urll)
            )
            startActivity(intent)
        }
    }

    var imageListener: ImageListener = object : ImageListener {
        override fun setImageForPosition(position: Int, imageView: ImageView) {
            Glide.with(this@DetailPotensi).load(gambar?.getResourceId(position, 0)).into(imageView)
        }
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }
}
