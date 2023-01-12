package com.example.tugasakhir_pariwisata

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class MainActivityDaftar : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_daftar)
        val nama : EditText = findViewById(R.id.isiname)
        val email : EditText = findViewById(R.id.isiemail)
        val pw : EditText = findViewById(R.id.isipw)
        val button = findViewById<Button>(R.id.btn_sudahdaftar)
        button.setOnClickListener {

            if (nama.text.toString().isNotEmpty() and
                email.text.toString().isNotEmpty() and
                pw.text.toString().isNotEmpty() )
            {
                val user = User(nama.text.toString(),email.text.toString(),pw.text.toString())
                val db = db_helper(this)
                db.insertUser(user)
                val idUser = db.checkUser(nama.text.toString(),pw.text.toString())
                val bundle = Bundle()
                bundle.putString("iduser", idUser.toString())
                val intent =  Intent(this, MainActivitySudahDaftar::class.java)
                intent.putExtras(bundle)
                startActivity(intent)
            }
            else {
                val toast = Toast.makeText(applicationContext, "Lengkapi Seluruh Data!", Toast.LENGTH_LONG)
                toast.show()
            }
        }
    }
}
