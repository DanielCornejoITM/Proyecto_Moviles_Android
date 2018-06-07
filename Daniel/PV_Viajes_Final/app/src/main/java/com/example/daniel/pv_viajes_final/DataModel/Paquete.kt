package com.example.daniel.pv_viajes_final.DataModel

import com.google.firebase.database.DataSnapshot

class Paquete (snapshot: DataSnapshot){
    lateinit var id :String
    lateinit var v_Destino:String
    lateinit var v_Dias:String
    lateinit var v_Precio:String



    init {
        try {
            val data: HashMap<String, Any> =snapshot.value as HashMap<String, Any>
            id=snapshot.key
            v_Destino= data["destino"] as String
            v_Dias= data["dias"] as String
            v_Precio=data["precio"] as String


        }catch (e :Exception){
            e.printStackTrace()
        }
    }
}