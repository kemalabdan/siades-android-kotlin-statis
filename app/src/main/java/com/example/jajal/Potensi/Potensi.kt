package com.example.jajal.Potensi

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import com.example.jajal.R
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.LatLngBounds
import com.google.android.gms.maps.model.MarkerOptions

class Potensi : AppCompatActivity(), OnMapReadyCallback, View.OnClickListener {


    lateinit var map: GoogleMap
    lateinit var normal: Button
    lateinit var satelit: Button
    lateinit var hybrid: Button
    lateinit var terrain: Button
    private val latitude = doubleArrayOf(
        -7.8535067,
        -7.8756356,
        -7.8519174,
        -7.8575882,
        -7.8709064,
        -7.8530676
    )

    private val longtitude = doubleArrayOf(
        110.3401805,
        110.3338674,
        110.3431619,
        110.3364265,
        110.3309546,
        110.3224006
    )

    private val url = arrayOf(
        "https://goo.gl/maps/K4tSxzyVYX5MApYe7",
        "https://goo.gl/maps/mEmmwXaagvSeQTM29",
        "https://goo.gl/maps/5KAGtwLiwuQZmmFV7",
        "https://goo.gl/maps/MtcGE3dvgmuWh15u7",
        "https://goo.gl/maps/SY39Po6NzHp38dHy8",
        "https://goo.gl/maps/eEfUd4AKJE9EqGhq6"
    )

    private var detailList: MutableList<String>? = null
    private var judulList: MutableList<String>? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_potensi)
        supportActionBar?.setDisplayShowHomeEnabled(true)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        detailList = mutableListOf()
        judulList = mutableListOf()

        val mapFragment = supportFragmentManager.findFragmentById(R.id.mapFragment) as SupportMapFragment
        mapFragment.getMapAsync(this)

        normal = findViewById(R.id.normal)
        satelit = findViewById(R.id.satelit)
        hybrid = findViewById(R.id.hybrid)
        terrain = findViewById(R.id.terrain)

        normal.setOnClickListener(this)
        satelit.setOnClickListener(this)
        hybrid.setOnClickListener(this)
        terrain.setOnClickListener(this)
    }


    override fun onMapReady(p0: GoogleMap?) {

        val nama = resources.getStringArray(R.array.listdaerah)
        val detail = resources.getStringArray(R.array.isidetaildaerah)
        val gambar = resources.obtainTypedArray(R.array.gambardaerah)

        map = p0!!

        for (i in nama.indices) {
            val markerOptions = MarkerOptions().position(LatLng(latitude[i], longtitude[i])).title(nama[i])
            val marker = map.addMarker(markerOptions)
            marker.showInfoWindow()
            marker.tag = i
            map.moveCamera(CameraUpdateFactory.newLatLngZoom(LatLng(latitude[i], longtitude[i]), 10F))
            detailList?.add(detail[i])
            judulList?.add(nama[i])
            onclickMarker(detailList, map, judulList)
        }

    }

    private fun onclickMarker(
        detailList: MutableList<String>?,
        map: GoogleMap,
        judulList: MutableList<String>?
    ) {
        map.setOnMarkerClickListener { marker ->
            val intent = Intent(this@Potensi, DetailPotensi::class.java)
            intent.putExtra("URL", url[marker.tag.toString().toInt()])
            intent.putExtra("DETAIL", detailList?.get(marker.tag.toString().toInt()))
            intent.putExtra("LAT", latitude[marker.tag.toString().toInt()])
            intent.putExtra("LON", longtitude[marker.tag.toString().toInt()])
            intent.putExtra("JUDUL", judulList?.get(marker.tag.toString().toInt()))
            intent.putExtra("position", marker.tag.toString().toInt())
            startActivity(intent)
            return@setOnMarkerClickListener true
        }

    }


    override fun onClick(v: View?) {
        when (v!!.id) {
            R.id.normal -> {
                map.mapType = GoogleMap.MAP_TYPE_NORMAL
            }
            R.id.satelit -> {
                map.mapType = GoogleMap.MAP_TYPE_SATELLITE
            }
            R.id.hybrid -> {
                map.mapType = GoogleMap.MAP_TYPE_HYBRID
            }
            R.id.terrain -> {
                map.mapType = GoogleMap.MAP_TYPE_TERRAIN
            }
        }
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }

}
