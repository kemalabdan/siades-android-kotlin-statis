package com.example.jajal.Lainnya.Lembaga

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.jajal.R
import kotlinx.android.synthetic.main.list_lembaga.view.*
import org.jetbrains.anko.sdk25.coroutines.onClick

class LembagaAdapter(val context : Context, val items: List<Bagian>, val listener: (Bagian)-> Unit) : RecyclerView.Adapter<LembagaAdapter.ViewHolder>(){
    override fun onCreateViewHolder(viewGroup: ViewGroup, position: Int): ViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.list_lembaga,viewGroup,false)
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
        val textTitle = view.namalembaga

        fun bindItem(item: Bagian, listener: (Bagian) -> Unit){/*tambahkan listener yang tadi sudah di buat*/
            textTitle.text=item.judul
            //membuat onclick
            itemView.onClick {
                listener(item)
            }
        }
    }
}