package com.example.jajal.Galeri

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.GridLayoutManager
import com.example.jajal.R
import kotlinx.android.synthetic.main.activity_galeri.*

class Galeri : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_galeri)
        supportActionBar?.setDisplayShowHomeEnabled(true)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        val url = listOf(
            Galerigambar(nama = "SOSIALISASI DAN PEMBINAAN PHBS TAHUN 2018", gambarr = "https://pendowoharjo.bantulkab.go.id/assets/files/artikel/sedang_1537171524DSC08544.JPG"),
            Galerigambar(nama = "LAKU TIRAKAT MUBENG DESO MALAM SATU SURO 1440 H", gambarr = "https://pendowoharjo.bantulkab.go.id/assets/files/artikel/sedang_1536621250DSC08507.JPG"),
            Galerigambar(nama = "FASILITASI PEMBANGUNAN PENATAAN KAWASAN KUMUH, RTH, AREA BERMAIN ANAK DAN PJU DARI KEMENTRIAN PUPR TAHUN 2018", gambarr = "https://rumahdijual.com/attachments/yogyakarta/18732471d1516339262-hanya-bulan-januari-diskon-100-jt-beli-tanah-pendowoharjo-green-laras-bantul-5-.jpg"),
            Galerigambar(nama = "PEMBAGIAN SERTIFIKAT PTSL TAHAP 1 TAHUN 2017", gambarr = "http://kandangan-kandangan.temanggungkab.go.id/assets/files/artikel/sedang_1554956751IMG_0736.JPG"),
            Galerigambar(nama = "PENYEMBELIHAN HEWAN QURBAN 1439 H PENDOWOHARJO", gambarr = "https://apollo-singapore.akamaized.net/v1/files/hryhoyvfwbt42-ID/image;s=966x691;olx-st/_1_.jpg"),
            Galerigambar(nama = "MONEV PEMBANGUNAN PADAT KARYA TAHUN 2018", gambarr = "https://trimulyo.bantulkab.go.id/assets/files/artikel/sedang_1536863976IMG_4995x.jpg")
        )

        val adapterr = GaleriAdapter(url,this)

        recyclerViewGaleri.setHasFixedSize(true)
        recyclerViewGaleri.layoutManager = GridLayoutManager(this, 2)
        recyclerViewGaleri.adapter = adapterr
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }
}
