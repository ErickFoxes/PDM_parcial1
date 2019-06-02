package com.example.parcial1_pdm.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.parcial1_pdm.R
import com.example.parcial1_pdm.pojos.Equipo
import com.example.parcial1_pdm.pojos.Partido

class PartidoListAdapter (val clickListener : (Partido) -> Unit
) : RecyclerView.Adapter<PartidoListAdapter.ViewHolder>() {

    private var partidos = emptyList<Partido>()
    private var equipos = emptyList<Equipo>()

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(item: Partido, clickListener: (Partido) -> Unit) = with(itemView){
            textView.text = item.Equipo1
            textView2.text = item.Equipo2
            textView3.text = item.Fecha


            this.setOnClickListener{
                clickListener(item)}
        }
        //val wordItemView: TextView = itemView.findViewById(R.id.textView)
        //val authItemView: TextView = itemView.findViewById(R.id.textView2)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.recyclerview_item, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) = holder.bind(partidos[position], clickListener) /*{
        //Log.d("algo", words.size.toString() + authors.size.toString())
        val current = words[position]
        //val currenta = authors[position]
        holder.wordItemView.text = current.title
        //holder.authItemView.text = currenta.name_author
    }*/

    internal fun setpartidos(partidos: List<Partido>) {
        this.partidos = partidos
        notifyDataSetChanged()
    }
    override fun getItemCount() = partidos.size
}