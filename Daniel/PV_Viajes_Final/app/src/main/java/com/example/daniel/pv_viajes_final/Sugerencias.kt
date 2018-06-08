package com.example.daniel.pv_viajes_final

import android.content.Intent
import android.graphics.Color
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.util.Log
import android.widget.Button
import android.widget.Toast
import com.google.gson.GsonBuilder
import kotlinx.android.synthetic.main.activity_sugerencias.*
import okhttp3.*
import java.io.IOException

class Sugerencias : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sugerencias)


        recyclerSugerencias.layoutManager=LinearLayoutManager(this)




        fetchJson()




    }

    override fun onResume() {
        super.onResume()

        var Botoncarro = findViewById<Button>(R.id.buttonSuger)

       Botoncarro.setOnClickListener {
           startActivity(Intent(applicationContext,Carrito::class.java))
       }
    }

    fun fetchJson(){


        val url="https://api.sandbox.amadeus.com/v1.2/flights/inspiration-search?apikey=JkCLqihp0zjGVBvrnfUeqvsbFisA1RYM&origin=MEX"
        //val url="https//api.letsbuildthatapp.com/youtube/home_feed"

        val request= Request.Builder().url(url).build()
        val client =OkHttpClient()
        client.newCall(request).enqueue(object : Callback {
            override fun onFailure(call: Call?, e: IOException?) {
                Toast.makeText(this@Sugerencias,"Fallo Al leer la API",Toast.LENGTH_SHORT).show()
            }

            override fun onResponse(call: Call?, response: Response?) {
            val body= response?.body()?.string()
                Log.i("Cuerpos",body)



                val gson =GsonBuilder().create()
               val homefeed= gson.fromJson(body,Homefeed::class.java)
                runOnUiThread {

                    recyclerSugerencias.adapter=MainAdpapterSugerencias(homefeed,this@Sugerencias)

                }
            }


        })


    }

    class Homefeed(val results:List<Result>)

    class Result(val destination:String,val departure_date :String, val return_date :String ,val price:String,val airline:String)


}
