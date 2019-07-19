package com.example.jajal.Berita

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bumptech.glide.Glide
import com.example.jajal.R
import kotlinx.android.synthetic.main.list_post.view.*
import org.jetbrains.anko.sdk25.coroutines.onClick

class BeritaAdapter(val context : Context, val items: List<PostBerita>,/*Tambahkan konstruktor untuk detainya */ val listener: (PostBerita)-> Unit) : RecyclerView.Adapter<BeritaAdapter.ViewHolder>(){
    override fun onCreateViewHolder(viewGroup: ViewGroup, position: Int): ViewHolder /*Klik alt enter -> constructor invocation*/{
        val view = LayoutInflater.from(context).inflate(R.layout.list_post,viewGroup,false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return items.size
    }

    override fun onBindViewHolder(/*ganti variablenya agar tidak bingung*/viewHolder: ViewHolder, position: Int) {
        viewHolder.bindItem(items [position], listener) /*<- panggil variable listener yang di buat di atas tadi*/
    }

    class ViewHolder (view:View): RecyclerView.ViewHolder (view){
        /*buat variable dan panggil widget yang mau di tampilkan di main activitynya*/
        val textTitle = view.txtJudulPost
        val gambar = view.imgGambarPost
        val textTgl = view.txtTglPost

        fun bindItem(item: PostBerita, listener: (PostBerita) -> Unit){/*tambahkan listener yang tadi sudah di buat*/
            textTitle.text=item.judul
            textTgl.text=item.tanggal
            Glide.with(itemView.context).load(item.gambar).into(gambar)
            //membuat onclick
            itemView.onClick {
                listener(item)
            }
        }
    }
}