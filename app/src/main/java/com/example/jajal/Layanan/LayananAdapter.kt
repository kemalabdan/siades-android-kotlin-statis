package com.example.jajal.Layanan

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bumptech.glide.Glide
import com.example.jajal.R
import kotlinx.android.synthetic.main.list_layanan.view.*
import kotlinx.android.synthetic.main.list_post.view.*
import kotlinx.android.synthetic.main.list_potensi.view.*
import org.jetbrains.anko.sdk25.coroutines.onClick

class LayananAdapter(val context : Context, val items: List<Jenis>, val listener: (Jenis, pos : Int)-> Unit) : RecyclerView.Adapter<LayananAdapter.ViewHolder>(){
    override fun onCreateViewHolder(viewGroup: ViewGroup, position: Int): ViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.list_layanan,viewGroup,false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return items.size
    }

    override fun onBindViewHolder(/*ganti variablenya agar tidak bingung*/viewHolder: ViewHolder, position: Int) {
        viewHolder.bindItem(items [position], listener, position) /*<- panggil variable listener yang di buat di atas tadi*/
    }

    class ViewHolder (view:View): RecyclerView.ViewHolder (view){
        /*buat variable dan panggil widget yang mau di tampilkan di main activitynya*/
        val textTitle = view.namalayanan

        fun bindItem(item: Jenis, listener: (Jenis, pos : Int) -> Unit, position: Int){/*tambahkan listener yang tadi sudah di buat*/
            textTitle.text=item.judul
            //membuat onclick
            itemView.onClick {
                listener(item, position)
            }
        }
    }
}