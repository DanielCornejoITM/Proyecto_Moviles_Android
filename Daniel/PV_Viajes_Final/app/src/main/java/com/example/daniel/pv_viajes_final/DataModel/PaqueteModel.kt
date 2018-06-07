package com.example.daniel.pv_viajes_final.DataModel

import android.util.Log
import com.google.firebase.database.*
import java.util.*
import kotlin.collections.ArrayList

object PaqueteModel: Observable() {

    private var ValorEscuchador:ValueEventListener?=null
    private var listPaquete:ArrayList<Paquete>?= ArrayList()


private fun getDatabaseRef():DatabaseReference?{

    return FirebaseDatabase.getInstance().reference.child("paquete")
}

    init {
        if (ValorEscuchador !=null){
            getDatabaseRef()?.removeEventListener(ValorEscuchador)
        }
        ValorEscuchador=null
        Log.i("PaqueteModel","Error Linea 26")

        ValorEscuchador=object:ValueEventListener{
            override fun onCancelled(p0: DatabaseError?) {

                if (p0!=null){
                    Log.i("PaqueteModel","Linea 30 Actualizacion de Datos cancelado ${p0.message}")
                }

            }

            override fun onDataChange(p0: DataSnapshot?) {
                try {
                    Log.i("PaqueteModel","Datos Actualizados Linea 29")
                    val data:ArrayList<Paquete> = ArrayList()
                    if (p0 != null){

                        for (snapshot: DataSnapshot in p0.children){

                            try {

                                data.add(Paquete(snapshot))

                            }catch (e: Exception){
                                e.printStackTrace()
                            }
                        }
                        listPaquete=data
                        Log.i("PaqueteModel","Datos Actualizados"+ listPaquete!!.size+"En la cache")
                        setChanged()
                        notifyObservers()
                    }

                }catch (e: Exception){
                    e.printStackTrace()

                }


            }


        }
        getDatabaseRef()?.addValueEventListener(ValorEscuchador)

    }
fun SacarInfo():ArrayList<Paquete>?{
    return listPaquete


}
}