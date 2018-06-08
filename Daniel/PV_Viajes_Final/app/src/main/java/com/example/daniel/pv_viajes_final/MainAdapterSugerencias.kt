package com.example.daniel.pv_viajes_final

import android.content.Context
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import android.view.View
import com.example.daniel.pv_viajes_final.Sugerencias

import kotlinx.android.synthetic.main.molde_carrito.view.*
import kotlinx.android.synthetic.main.molde_sugerencias.view.*


class MainAdpapterSugerencias(val homefeeed:Sugerencias.Homefeed,val contexto: Context): RecyclerView.Adapter<CustomViewHolder>(){
    //val Lista = listOf<String>("Hola","Como","Estas")



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CustomViewHolder {
        //Como hacemos el view
        val layInflater=LayoutInflater.from(parent.context)
        val cellfoRow=layInflater.inflate(R.layout.molde_sugerencias,parent,false)
        return CustomViewHolder(cellfoRow)

    }

    override fun onBindViewHolder(holder: CustomViewHolder, position: Int) {
        //val DestinosTit=Lista.get(position)

        val results=homefeeed.results.get(position)

        Log.i("MOMA",results.destination)

        holder?.view?.Text_Ciudad_S?.text=results.destination
        holder?.view?.Text_Precio_S?.text=results.price
        holder?.view?.Text_FechaS_S.text=results.departure_date
        holder?.view?.Text_FechaY_S.text=results.return_date

        holder?.view?.BotonSug.setOnClickListener(
                {
                    AgregarCarrito(contexto).addItem(results.destination,results.departure_date,results.return_date,results.price)

                }
        )



    }



    override fun getItemCount(): Int {

        return homefeeed.results.count()
    }




}

class CustomViewHolder(val view: View):RecyclerView.ViewHolder(view){



}