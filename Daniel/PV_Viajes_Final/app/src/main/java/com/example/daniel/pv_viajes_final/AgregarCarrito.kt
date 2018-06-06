package com.example.daniel.pv_viajes_final

import android.widget.Toast

class AgregarCarrito{
    var DestinoC :String?=null
    var DiasC    :Int?=null
    var PrecioC : Float?=null


constructor(Destino:String,Duracion:Int,Costo:Float) {
    this.DestinoC=Destino
    this.DiasC=Duracion
    this.PrecioC=Costo
    println(DestinoC)
    println(DiasC.toString())
    println(PrecioC.toString())



}

}