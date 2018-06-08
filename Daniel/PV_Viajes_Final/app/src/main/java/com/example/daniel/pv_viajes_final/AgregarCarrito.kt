package com.example.daniel.pv_viajes_final

import android.content.Context
import android.widget.Toast
import com.google.firebase.database.FirebaseDatabase
import java.util.*


class AgregarCarrito{
    var firebaseData = FirebaseDatabase.getInstance().reference
    val hijo1:String?="carrito"

    var mcontexto:Context?=null

    var hijo2:String?=""


    constructor(context: Context) {

    this.mcontexto=context


}


    fun addItem(DestinoC: String,Salida: String,Llegada: String,PrecioC: String) {

        var r =(0..1000).random()
        hijo2=r.toString()

        Toast.makeText(mcontexto,"Recibo Destino:$DestinoC\nDias: $Salida\n y Precio:$PrecioC\n para el hijo= $hijo2 ",Toast.LENGTH_LONG).show()

        try {
            firebaseData
                    .child(hijo1)
                    .child(hijo2)
                    .child("destino")
                    .setValue(DestinoC)


            firebaseData
                    .child(hijo1)
                    .child(hijo2)
                    .child("precio")
                    .setValue(PrecioC)


            firebaseData
                    .child(hijo1)
                    .child(hijo2)
                    .child("salida")
                    .setValue(Salida)
            firebaseData
                    .child(hijo1)
                    .child(hijo2)
                    .child("llegada")
                    .setValue(Salida)

            Toast.makeText(mcontexto,"Segun, ya añadio",Toast.LENGTH_LONG).show()


        }catch (e: Exception) {
            Toast.makeText(mcontexto, "Error: ${e.message}", Toast.LENGTH_LONG).show()

        }

    }

    fun ClosedRange<Int>.random() =
            Random().nextInt(endInclusive - start) +  start

}