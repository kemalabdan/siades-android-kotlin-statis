package com.example.jajal.Fragment

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.jajal.R

class Pengaduan : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        getActivity()?.setTitle("PENGADUAN");
        val view: View
        view = inflater.inflate(R.layout.activity_pengaduan,null)
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
//        btnKirim.setOnClickListener {
//            val aduan = inputPengaduan.text.toString()
//            if (aduan.isEmpty()) {
//                Toast.makeText(this, "Kolom Pengaduan harus diisi", Toast.LENGTH_SHORT).show()
//                return@setOnClickListener
//            }
//        }
    }
}
