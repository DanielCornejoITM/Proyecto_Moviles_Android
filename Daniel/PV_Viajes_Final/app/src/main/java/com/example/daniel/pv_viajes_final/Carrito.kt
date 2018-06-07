package com.example.daniel.pv_viajes_final


import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.ListView
import com.example.daniel.pv_viajes_final.Adapters.PaqueteCarroAdapter
import com.example.daniel.pv_viajes_final.DataModel.CarroModel
import com.example.daniel.pv_viajes_final.DataModel.Paquete
import com.example.daniel.pv_viajes_final.DataModel.PaqueteModel
import java.util.*

class Carrito : AppCompatActivity(), Observer {

    private  var mPaqueteListAdapter2 : PaqueteCarroAdapter? = null




    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cosa1)

        CarroModel

        CarroModel.addObserver(this)
        val datalist: ListView = findViewById(R.id.MilistaCarrito)
        val data :ArrayList<Paquete> = ArrayList()

        mPaqueteListAdapter2 = PaqueteCarroAdapter(this,R.layout.molde_carrito,data)
        datalist.adapter=mPaqueteListAdapter2


    }


    override fun update(o: Observable?, arg: Any?) {

        mPaqueteListAdapter2?.clear()
        val data =CarroModel.SacarInfo()
        if (data!=null){

            mPaqueteListAdapter2?.clear()
            mPaqueteListAdapter2?.addAll(data)
            mPaqueteListAdapter2?.notifyDataSetChanged()

        }


    }


    override fun onResume() {
        super.onResume()
        CarroModel.addObserver(this)
    }

    override fun onPause() {
        super.onPause()
        CarroModel.deleteObserver(this)
    }

    override fun onStop() {
        super.onStop()
        CarroModel.deleteObserver(this)
    }

}
