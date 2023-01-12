package com.example.tugasakhir_pariwisata

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val loginBtn = findViewById<Button>(R.id.btn_login)
        val username = findViewById<EditText>(R.id.username)
        val pw = findViewById<EditText>(R.id.password)
        val db = db_helper(this)
        loginBtn.setOnClickListener {
            if (username.text.toString().isNotEmpty() and pw.text.toString().isNotEmpty()) {
                val idUser = db.checkUser(username.text.toString(),pw.text.toString())
                if (idUser>0){
                    val bundle = Bundle()
                    val intent =  Intent(this, ActivityTampilanUtama::class.java)
                    bundle.putString("iduser", idUser.toString())
                    intent.putExtras(bundle)
                    startActivity(intent)
                }else{
                    Toast.makeText(applicationContext,"Email belum terdaftar", Toast.LENGTH_LONG).show()
                }
            }
            else {
                Toast.makeText(applicationContext, "Lengkapi Username dan Password", Toast.LENGTH_LONG).show()
            }

        }

        val button1 = findViewById<Button>(R.id.btn_oohhh)
        button1.setOnClickListener {
            val intent =  Intent(this, MainActivityDaftar::class.java)
            startActivity(intent)
        }

        val button_browser = findViewById<Button>(R.id.ajg)
        button_browser.setOnClickListener(View.OnClickListener {
            val intent = Intent(Intent.ACTION_VIEW)
            intent.data = Uri.parse("https://www.google.com/maps/place/PT.SOJURN.com/@-6.1695697,106.7222995,19z/data=!3m1!4b1!4m12!1m6!3m5!1s0x2e" +
                    "69f828078d6231:0x34e15c05ba678f14!2sKosan+25!8m2!3d-6.1695265!" +
                    "4d106.7228263!3m4!1s0x2e69f901b32764ab:0x93b2885a09bd4cca!8m2!3d-6.1695697!4d106.7228467")
            startActivity(intent)
        })

    }
}
