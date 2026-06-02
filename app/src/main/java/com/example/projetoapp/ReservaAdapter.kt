package com.example.projetoapp

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class ReservaAdapter (private  val reservas : List<String>) : RecyclerView.Adapter<ReservaAdapter.ReservasViewHolder>(){

    class ReservasViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val titulo: TextView = itemView.findViewById(R.id.txtTituloReserva)
    }


    override fun onCreateViewHolder(
        parent: ViewGroup,
        p1: Int
    ): ReservaAdapter.ReservasViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_reserva, parent, false)
        return ReservasViewHolder(view)
    }

    override fun onBindViewHolder(holder: ReservaAdapter.ReservasViewHolder, position: Int) {
        val reservas = reservas[position]
        holder.titulo.text = reservas

    }

    override fun getItemCount(): Int {
        return reservas.size
    }
}