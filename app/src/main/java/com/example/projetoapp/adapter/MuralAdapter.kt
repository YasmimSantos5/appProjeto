package com.example.projetoapp.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.projetoapp.R

class MuralAdapter (private  val mural : List<String>) : RecyclerView.Adapter<MuralAdapter.MuralViewHolder>(){

    class MuralViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val titulo: TextView = itemView.findViewById(R.id.txtTituloMural)
    }


    override fun onCreateViewHolder(
        parent: ViewGroup,
        p1: Int
    ): MuralViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_mural, parent, false)
        return MuralViewHolder(view)
    }

    override fun onBindViewHolder(holder: MuralViewHolder, position: Int) {
        holder.titulo.text = mural[position]
    }

    override fun getItemCount(): Int {
        return mural.size
    }
}