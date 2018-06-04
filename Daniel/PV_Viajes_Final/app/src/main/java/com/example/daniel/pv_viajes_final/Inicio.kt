package com.example.daniel.pv_viajes_final

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.Toast
import com.facebook.login.LoginManager

class Inicio : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_inicio)

        var fermer = findViewById<Button>(R.id.Cerrar)
        fermer.setOnClickListener(View.OnClickListener {

            Toast.makeText(applicationContext, "Cerrando Sesion", Toast.LENGTH_LONG).show()
            LoginManager.getInstance().logOut()
            finish()



        })

        }

    }




