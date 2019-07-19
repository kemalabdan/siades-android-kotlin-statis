package com.example.jajal.Fragment

import android.content.Intent
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import com.bumptech.glide.Glide
import com.example.jajal.Berita.Berita
import com.example.jajal.Galeri.Galeri
import com.example.jajal.Layanan.Layanan
import com.example.jajal.Pengumuman.Pengumuman
import com.example.jajal.Post
import com.example.jajal.Potensi.Potensi
import com.example.jajal.Program.Program
import com.example.jajal.R
import com.synnapps.carouselview.CarouselView
import com.synnapps.carouselview.ImageListener
import kotlinx.android.synthetic.main.activity_home.*

class Home : Fragment() {

    lateinit var carouselView: CarouselView

    val sampleImages= intArrayOf(
        R.drawable.post1,
        R.drawable.post2,
        R.drawable.post3,
        R.drawable.post4,
        R.drawable.post5
    )
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        val view: View
        view = inflater.inflate(R.layout.activity_home,null)
        carouselView=view.findViewById(R.id.carouselView)
        carouselView.setPageCount(5)
        carouselView.setImageListener(imageListener)
        carouselView.setImageClickListener { position ->
            if (position==0){
                val intent = Intent(getActivity(), Post::class.java)
                intent?.putExtra("Detail", getString(R.string.post1))
                intent?.putExtra("Gambar", sampleImages[0])
                intent?.putExtra("Judul", "Desa Ramah Anak : Solusi Interaktif dan Edukatif Perkembangan Anak Masa Kini")
                startActivity(intent)
            }else if (position==1){
                val intent = Intent(getActivity(), Post::class.java)
                intent?.putExtra("Detail", getString(R.string.post2))
                intent?.putExtra("Gambar", sampleImages[1])
                intent?.putExtra("Judul", "Pemdes Pendowoharjo Gelar Ritual \"Laku Tirakat Mubeng Deso\"")
                startActivity(intent)
            }else if (position==2){
                val intent = Intent(getActivity(), Post::class.java)
                intent?.putExtra("Detail", getString(R.string.post3))
                intent?.putExtra("Gambar", sampleImages[2])
                intent?.putExtra("Judul", "Desa Pendowoharjo Terpilih Sebagai Desa Sadar Jaminan Sosial Ketenagakerjaan Tahun 2018")
                startActivity(intent)
            }else if (position==3){
                val intent = Intent(getActivity(), Post::class.java)
                intent?.putExtra("Detail", getString(R.string.post4))
                intent?.putExtra("Gambar", sampleImages[3])
                intent?.putExtra("Judul", "Penilaian Arsip Desa Se-Kabupaten Bantul Tahun 2018")
                startActivity(intent)
            }else if (position==4){
                val intent = Intent(getActivity(), Post::class.java)
                intent?.putExtra("Detail", getString(R.string.post5))
                intent?.putExtra("Gambar", sampleImages[4])
                intent?.putExtra("Judul", "PKK Desa Pendowoharjo Gencarkan PHBS dan Bagikan Plakat Dilarang Membuang Sampah")
                startActivity(intent)
            }else{}
        }
        return view
    }


    var imageListener: ImageListener = object : ImageListener {
        override fun setImageForPosition(position: Int, imageView: ImageView) {
            Glide.with(this@Home).load(sampleImages[position]).into(imageView)
        }
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        button_layanan.setOnClickListener { startActivity(Intent(activity, Layanan::class.java)) }
        button_berita.setOnClickListener { startActivity(Intent(activity, Berita::class.java)) }
        button_pengumuman.setOnClickListener { startActivity(Intent(activity, Pengumuman::class.java)) }
        button_galeri.setOnClickListener { startActivity(Intent(activity, Galeri::class.java)) }
        button_potensi.setOnClickListener { startActivity(Intent(activity, Potensi::class.java)) }
        button_program.setOnClickListener { startActivity(Intent(activity, Program::class.java)) }
    }
}
