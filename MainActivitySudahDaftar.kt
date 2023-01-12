package com.example.tugasakhir_pariwisata

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.drawerlayout.widget.DrawerLayout
import com.google.android.material.navigation.NavigationView

class MainActivitySudahDaftar : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener{

    private lateinit var mToggle: ActionBarDrawerToggle
    private lateinit var menu : Menu
    private lateinit var menuItem : MenuItem


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_sudah_daftar)
        val db = db_helper(this)
        supportActionBar?.setHomeButtonEnabled(true)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        val drawer_layout = findViewById<DrawerLayout>(R.id.drawer_layout)
        mToggle = ActionBarDrawerToggle(this, drawer_layout, R.string.open, R.string.close)

        drawer_layout.addDrawerListener(mToggle)
        mToggle.syncState()

        val menu_nav = findViewById<NavigationView>(R.id.nav_view)
        menu_nav.setNavigationItemSelectedListener(this)

        val button = findViewById<Button>(R.id.btn_gomenu)
        button.setOnClickListener {
            val bundle :Bundle ?= intent.extras
            val idUser = bundle!!.getString("iduser")
            val bundle1 = Bundle()
            val intent =  Intent(this, ActivityTampilanUtama::class.java)
            bundle1.putString("iduser", idUser.toString())
            intent.putExtras(bundle)
            startActivity(intent)
        }
    }

    override fun onOptionsItemSelected(item: android.view.MenuItem): Boolean {
        return mToggle.onOptionsItemSelected(item)
    }

    override fun onNavigationItemSelected(p0: MenuItem): Boolean {
        when (p0.itemId) {
            R.id.home_activity -> {
                val bundle :Bundle ?= intent.extras
                val idUser = bundle!!.getString("iduser")
                val bundle1 = Bundle()
                val intent =  Intent(this, ActivityTampilanUtama::class.java)
                bundle1.putString("iduser", idUser.toString())
                intent.putExtras(bundle)
                startActivity(intent)
                true
            }
            R.id.profil_activity -> {
                startActivity(Intent(this,MainActivityPesanTiket::class.java))
                true
            }
            R.id.keluar_activity -> {
                startActivity(Intent(this,MainActivity::class.java))
                true
            }
            else -> true
        }
        return true
    }

}
