package com.example.daniel.pv_viajes_final

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import android.view.View
import kotlinx.android.synthetic.main.modecatalogo.view.*


class MainAdpapterSugerencias(val homefeeed:Sugerencias.Homefeed): RecyclerView.Adapter<CustomViewHolder>(){
    val Lista = listOf<String>("Hola","Como","Estas")



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CustomViewHolder {
        //Como hacemos el view
        val layInflater=LayoutInflater.from(parent.context)
        val cellfoRow=layInflater.inflate(R.layout.modecatalogo,parent,false)
        return CustomViewHolder(cellfoRow)

    }

    override fun onBindViewHolder(holder: CustomViewHolder, position: Int) {
        //val DestinosTit=Lista.get(position)

        val results=homefeeed.results.get(position)
        holder?.view?.Destino1?.text=results.destination
        holder?.view?.Costoso1?.text=results.price
        holder.view?.Duraciones1.text=results.departure_date


    }



    override fun getItemCount(): Int {

        return homefeeed.results.count()
    }




}

class CustomViewHolder(val view: View):RecyclerView.ViewHolder(view){



}