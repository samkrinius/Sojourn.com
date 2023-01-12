package com.example.tugasakhir_pariwisata

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.widget.Toolbar

class MainActivityPesanTiket : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_pesan_tiket)
        val bundle3 :Bundle ?= intent.extras
        val idUser = bundle3!!.getString("iduser")

        val button:Button = findViewById(R.id.btnCheckout)


        button.setOnClickListener {
            Toast.makeText(this, "Pesanan Anda Telah Masuk",Toast.LENGTH_LONG).show()
        }

        val toolbar : Toolbar = findViewById(R.id.back)
        toolbar.setOnClickListener{
            val bundle1 = Bundle()
            val intent1 =  Intent(this,ActivityTampilanUtama::class.java)
            bundle1.putString("iduser", idUser.toString())
            startActivity(intent1)
        }

    }
}
