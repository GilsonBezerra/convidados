package com.example.convidados.view.viewholder

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.convidados.R
import com.example.convidados.service.model.GuestModel

class GuestViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView) {

    fun bind(guest: GuestModel) {
      val textName = itemView.findViewById<TextView>(R.id.text_name) // Pegar o elemento/id da fragment
        textName.text = guest.name // Pegar o campo text da fragment e passar a variável da model
    }

}