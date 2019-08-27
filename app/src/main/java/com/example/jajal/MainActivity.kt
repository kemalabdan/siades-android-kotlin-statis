package com.example.jajal

import android.content.Intent
import android.os.Bundle
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentTransaction
import android.support.v7.app.AlertDialog
import android.support.v7.app.AppCompatActivity
import com.example.jajal.Fragment.Home
import com.example.jajal.Fragment.Lainnya
import com.example.jajal.Fragment.Pengaduan
import com.example.jajal.Fragment.Profil
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    lateinit var fm: FragmentManager
    lateinit var ft: FragmentTransaction

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)
        fm=supportFragmentManager
        ft=fm.beginTransaction()
        ft.replace(R.id.container,Home()).commit()

        nav_view.setOnNavigationItemSelectedListener {
            when (it.itemId) {
            R.id.navigation_home -> {
                fm = supportFragmentManager
                ft = fm.beginTransaction()
                ft.replace(R.id.container, Home()).commit()
                return@setOnNavigationItemSelectedListener true
            }
            R.id.navigation_pengaduan -> {
                fm = supportFragmentManager
                ft = fm.beginTransaction()
                ft.replace(R.id.container, Pengaduan()).commit()
                return@setOnNavigationItemSelectedListener true
            }
            R.id.navigation_profil -> {
                fm = supportFragmentManager
                ft = fm.beginTransaction()
                ft.replace(R.id.container, Profil()).commit()
                return@setOnNavigationItemSelectedListener true
            }
            R.id.navigation_lainnya -> {
                fm = supportFragmentManager
                ft = fm.beginTransaction()
                ft.replace(R.id.container, Lainnya()).commit()
                return@setOnNavigationItemSelectedListener true
            }
        }
            false
        }
    }

    override fun onBackPressed() {
        AlertDialog.Builder(this@MainActivity)
            .setIcon(android.R.drawable.ic_dialog_alert)
            .setTitle("Keluar Dari Aplikasi")
            .setMessage("Apakah Anda Ingin Keluar Dari Aplikasi?")
            .setPositiveButton("Ya", { dialog, which -> finish() })
            .setNegativeButton("Tidak", null)
            .show()
    }
}
