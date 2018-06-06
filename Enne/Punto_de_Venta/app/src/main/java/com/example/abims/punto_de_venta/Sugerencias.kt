package com.example.abims.punto_de_venta

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter

import kotlinx.android.synthetic.main.activity_sugerencias.*

import kotlinx.android.synthetic.main.molde_productos.view.*

class Sugerencias(var adaptador:ProductosAdaptador?=null)  : AppCompatActivity(){

    var listaCatalogo = ArrayList<Productos>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sugerencias)



        listaCatalogo.add(Productos(330.0F,"Sociedad"))
        listaCatalogo.add(Productos(80.0F,"Perro"))
        listaCatalogo.add(Productos(110.0F,"Gustavo"))
        listaCatalogo.add(Productos(330.0F,"Nieto"))
        listaCatalogo.add(Productos(900.0F,"Momo"))
        adaptador =ProductosAdaptador(this,this.listaCatalogo)


        MisSugerencias.adapter=adaptador

    }


    class ProductosAdaptador(contexto: Context, var ListaProductos: ArrayList<Productos>): BaseAdapter(){
        var contexto1:Context?=contexto



        override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
            val producto=ListaProductos[position]
            val inflador= contexto1!!.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
            val mivista =inflador.inflate(R.layout.molde_productos,null)
            mivista.Titulo.text=producto.Titulo!!
            mivista.Precio.text=producto.Precio.toString()!!
            return mivista

        }

        override fun getItem(position: Int): Any {
            return ListaProductos[position]

        }

        override fun getItemId(position: Int): Long {
            return  position.toLong()
        }

        override fun getCount(): Int {

            return ListaProductos.size
        }


    }
}
