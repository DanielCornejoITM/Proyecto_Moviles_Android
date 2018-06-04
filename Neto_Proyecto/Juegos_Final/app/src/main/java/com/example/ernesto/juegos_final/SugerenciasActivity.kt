package com.example.ernesto.juegos_final

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.widget.Button
import android.widget.Toast
import com.facebook.login.LoginManager
import kotlinx.android.synthetic.main.sugerencias.*

class SugerenciasActivity: AppCompatActivity(){
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)





        buttoncCarrito.setOnClickListener{
            val intent = Intent(this,CarritoActivity::class.java)
            startActivity(intent)
        }

    }
}