package com.example.daniel.pv_viajes_final

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import kotlinx.android.synthetic.main.sugerencias.*

class SugerenciaActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        ButtonLlegar.setOnClickListener{
            val intent = Intent(this,Inicio::class.java)
            startActivity(intent)
        }

    }
}