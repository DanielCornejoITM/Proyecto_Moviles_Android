package com.example.abims.punto_de_venta

import android.content.Context
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import kotlinx.android.synthetic.main.activity_new_catalogo.*

import kotlinx.android.synthetic.main.molde_productos.view.*

class NewCatalogo (var adaptador: NewCatalogo.ProductosAdaptador?=null) : AppCompatActivity() {

    var listaCatalogo = ArrayList<Productos>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_new_catalogo)


        listaCatalogo.add(Productos(30.0F,"Amigo"))
        listaCatalogo.add(Productos(20.0F,"Cosa"))
        listaCatalogo.add(Productos(10.0F,"Memo"))
        listaCatalogo.add(Productos(30.5F,"Hola"))

        adaptador = NewCatalogo.ProductosAdaptador(this, this.listaCatalogo)


        Micatalogo.adapter=adaptador
    }


    class ProductosAdaptador(contexto: Context, var ListaProductos: ArrayList<Productos>): BaseAdapter(){
        var contexto1: Context?=contexto



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
