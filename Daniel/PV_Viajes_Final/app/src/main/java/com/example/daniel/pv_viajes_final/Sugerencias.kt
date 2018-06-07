package com.example.daniel.pv_viajes_final

import android.content.Context
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import kotlinx.android.synthetic.main.activity_sugerencias.*
import kotlinx.android.synthetic.main.modecatalogo.view.*

class Sugerencias(var adaptador: Sugerencias.ProductosAdaptador?=null)  : AppCompatActivity() {
    var listaCatalogo = ArrayList<Productos>()


    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sugerencias)



        listaCatalogo.add(Productos(500.5F,"Huatulco",20))
        listaCatalogo.add(Productos(200.5F,"Cancun",5))
        listaCatalogo.add(Productos(900.5F,"Chiapas",100))
        listaCatalogo.add(Productos(900.5F,"Yucatan",100))

        adaptador = Sugerencias.ProductosAdaptador(this, this.listaCatalogo)
        MilistaSugerencia.adapter=adaptador



    }



    class ProductosAdaptador(contexto: Context, var ListaProductos: ArrayList<Productos>): BaseAdapter(){
        val contexto1: Context?=contexto



        override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
            val producto=ListaProductos[position]
            val inflador= contexto1!!.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
            val mivista =inflador.inflate(R.layout.modecatalogo,null)
            mivista.Destino1.text=producto.Destino!!
            mivista.Costoso1.text=producto.Precio.toString()!!
            mivista.Duraciones1.text=producto.Dias.toString()!!
            mivista.ButtonCompra.setOnClickListener({

                AgregarCarrito(contexto1).addItem(producto.Destino!!.toString(),producto.Dias!!.toString(),producto.Precio!!.toString())

            })


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
