package com.example.daniel.pv_viajes_final

import android.content.Context
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View

import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.Button
import android.widget.ListView
import android.widget.Toast
import com.example.daniel.pv_viajes_final.Adapters.PaqueteCardAdapter
import com.example.daniel.pv_viajes_final.DataModel.Paquete
import com.example.daniel.pv_viajes_final.DataModel.PaqueteModel
import kotlinx.android.synthetic.main.activity_catalogo.*
import kotlinx.android.synthetic.main.activity_sugerencias.view.*
import kotlinx.android.synthetic.main.modecatalogo.view.*
import java.util.*
import kotlin.collections.ArrayList

class Catalogo : AppCompatActivity(),Observer {

private  var mPaqueteListAdapter : PaqueteCardAdapter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_catalogo)
        PaqueteModel

        PaqueteModel.addObserver(this)
        val datalist: ListView= findViewById(R.id.Milista)
        val data :ArrayList<Paquete> = ArrayList()

        mPaqueteListAdapter = PaqueteCardAdapter(this,R.layout.modecatalogo,data)
        datalist.adapter=mPaqueteListAdapter

    }
    override fun update(o: Observable?, arg: Any?) {
        mPaqueteListAdapter?.clear()
        val data =PaqueteModel.SacarInfo()
        if (data!=null){

            mPaqueteListAdapter?.clear()
            mPaqueteListAdapter?.addAll(data)
            mPaqueteListAdapter?.notifyDataSetChanged()

        }


    }

    override fun onResume() {
        super.onResume()
        PaqueteModel.addObserver(this)
    }

    override fun onPause() {
        super.onPause()
        PaqueteModel.deleteObserver(this)
    }

    override fun onStop() {
        super.onStop()
        PaqueteModel.deleteObserver(this)
    }
}
