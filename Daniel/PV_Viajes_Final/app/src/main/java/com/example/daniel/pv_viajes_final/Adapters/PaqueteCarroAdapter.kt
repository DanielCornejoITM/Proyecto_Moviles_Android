package com.example.daniel.pv_viajes_final.Adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.TextView
import com.example.daniel.pv_viajes_final.AgregarCarrito
import com.example.daniel.pv_viajes_final.DataModel.Paquete
import com.example.daniel.pv_viajes_final.R


class PaqueteCarroAdapter(context: Context, resource: Int, list: ArrayList<Paquete>): ArrayAdapter<Paquete>(context,resource,list) {

    private var mResource: Int=0
    private var mList :ArrayList<Paquete>
    private var mFlayoutInflator : LayoutInflater
    private var mContext: Context =context
    init {
        this.mResource=resource
        this.mList=list
        this.mFlayoutInflator=mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        val returnView: View?
        if (convertView==null){

            returnView = try {
                mFlayoutInflator.inflate(mResource,null)

            }catch (e: Exception){
                e.printStackTrace()
                View(context)

            }
            setUI(returnView,position)
            return returnView
        }
        setUI(convertView,position)
        return convertView
    }

    private fun setUI(view: View, position: Int){
        val paquete: Paquete?=if (count>position) getItem(position) else null

        try {


            val Paquetedestino: TextView? = view.findViewById(R.id.Carro_ciudad)

            val Costo: TextView? = view.findViewById(R.id.Carro_cost)

            val Salida: TextView?=view.findViewById(R.id.Carro_sale)
            val llegada: TextView?=view.findViewById(R.id.Carro_llega)


            Paquetedestino?.text=paquete?.v_Destino?:""

            Costo?.text=paquete?.v_Precio?:""

            Salida?.text=paquete?.v_Sale?:""
            llegada?.text=paquete?.v_LLega?:""



        }catch (e:Exception){
            e.printStackTrace()

        }




    }

}