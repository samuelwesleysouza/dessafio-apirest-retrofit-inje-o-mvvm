package com.example.retrofit_2.Adapter


import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView

import androidx.recyclerview.widget.RecyclerView
import com.example.retrofit_2.R


import com.example.retrofit_2.model.last_position.LastPositionResponseItem
import com.example.retrofit_2.view.ListLastPositionActivity


class Adapter_ListaUsuario (val context: Context, val listaUsuario:MutableList<LastPositionResponseItem>):
    RecyclerView.Adapter<Adapter_ListaUsuario.LastPositionResponseItemViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LastPositionResponseItemViewHolder {
        val item_lista = LayoutInflater.from(context).inflate(R.layout.activity_last_position,parent,false)
         val holder = LastPositionResponseItemViewHolder(item_lista)
        return (holder)
    }
//
    override fun onBindViewHolder(holder: LastPositionResponseItemViewHolder, position: Int) {
        holder.ListLastPosition.text
    }

    override fun getItemCount(): Int = listaUsuario.size



    inner class LastPositionResponseItemViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        val ListLastPosition = itemView.findViewById<TextView>(R.id.rv_list)

    }
}
