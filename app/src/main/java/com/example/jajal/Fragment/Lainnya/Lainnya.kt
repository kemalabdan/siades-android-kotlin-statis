package com.example.jajal.Fragment.Lainnya

import android.content.Intent
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import com.example.jajal.Fragment.Lainnya.Lembaga.Lembaga
import com.example.jajal.R
import kotlinx.android.synthetic.main.activity_lainnya.*
import kotlinx.android.synthetic.main.activity_main.*

class Lainnya : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        getActivity()?.setTitle("LAINNYA");
        val view: View
        view = inflater.inflate(R.layout.activity_lainnya,null)
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        button_profdes.setOnClickListener { startActivity(Intent(activity, Profdes::class.java)) }
        button_lembaga.setOnClickListener { startActivity(Intent(activity, Lembaga::class.java)) }
        button_data.setOnClickListener { startActivity(Intent(activity, Data::class.java)) }
        button_policy.setOnClickListener { startActivity(Intent(activity, Policy::class.java)) }
    }
}
