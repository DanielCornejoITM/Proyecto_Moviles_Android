package com.example.daniel.pv_viajes_final

import android.os.AsyncTask
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import android.widget.Toast
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.toolbox.JsonObjectRequest
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import kotlinx.android.synthetic.main.activity_prueba.*
import org.json.JSONObject
import java.io.BufferedReader
import java.io.InputStreamReader
import java.math.BigDecimal
import java.net.URL

class Prueba : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_prueba)

        buttonA.setOnClickListener{

            Movimientos()
        }




    }

    fun Movimientos(){

        val url ="http://api.openweathermap.org/data/2.5/weather?q=Morelia,mx&APPID=8eb43a920f94a01bfa07488ea44cdb3e"

        val queue = Volley.newRequestQueue(this)


        //val url = "http://api.openweathermap.org/data/2.5/weather?q=Morelia,mx&APPID=8eb43a920f94a01bfa07488ea44cdb3e"

// Request a string response from the provided URL.
        val stringRequest = StringRequest(Request.Method.HEAD, url,
                Response.Listener<String> { response ->
                    // Display the first 500 characters of the response string.
                    textViewPrueba.text = "Response is: ${response.substring(0, 500)}"
                },
                Response.ErrorListener { textViewPrueba.text = "That didn't work!" })

// Add the request to the RequestQueue.
        queue.add(stringRequest)
    }

}
