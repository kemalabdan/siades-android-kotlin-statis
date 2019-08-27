package com.example.jajal.Fragment

import android.content.Intent
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.jajal.Lainnya.Data
import com.example.jajal.Lainnya.Lembaga.Lembaga
import com.example.jajal.Lainnya.Policy
import com.example.jajal.Lainnya.Profdes
import com.example.jajal.R
import kotlinx.android.synthetic.main.activity_lainnya.*

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
