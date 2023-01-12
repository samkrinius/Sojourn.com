package com.example.tugasakhir_pariwisata

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class ActivityTampilanUtama : AppCompatActivity(){

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tampilan_utama)
        val bundle2 :Bundle ?= intent.extras
        val idUser = bundle2!!.getString("iduser")
        val user : TextView = findViewById(R.id.user)
        val db = db_helper(this)
        val username = db.getUsername(idUser.toString())
        val button = findViewById<Button>(R.id.pesan)

        user.text = username
        button.setOnClickListener {

            val intent =  Intent(this, MainActivityPesanTiket::class.java)
            val bundle1 = Bundle()
            bundle1.putString("iduser", idUser.toString())
            intent.putExtras(bundle1)
            startActivity(intent)
        }


    }
}
