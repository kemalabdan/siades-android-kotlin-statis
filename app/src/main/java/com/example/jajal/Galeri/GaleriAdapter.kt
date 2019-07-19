package com.example.jajal.Galeri

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import com.bumptech.glide.Glide
import com.example.jajal.R
import kotlinx.android.synthetic.main.activity_galeri_adapter.view.*

class GaleriAdapter(url:List<Galerigambar>,context: Context):
    RecyclerView.Adapter<GaleriAdapter.ViewHolder>(){
    var context: Context
    val url:List<Galerigambar>
    init {
        this.context=context
        this.url=url
    }

    override fun getItemCount(): Int {
        return url.size
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        var v: View
        v= LayoutInflater.from(parent.context).inflate(R.layout.activity_galeri_adapter,parent,false)
        return ViewHolder(v)
    }


    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindItem(url [position])
    }

    class ViewHolder(view: View): RecyclerView.ViewHolder(view) {
        val tvNamaGambar = view.txtNamaGambar
        var gambar: ImageView
        init {
            gambar=itemView.findViewById(R.id.gambar)
        }

        fun bindItem(item: Galerigambar){
            tvNamaGambar.text=item.nama
            Glide.with(itemView.context).load(item.gambarr).into(gambar)
        }
    }
}
