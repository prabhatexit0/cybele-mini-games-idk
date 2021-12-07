package com.example.cybeleminigames.selectscreen

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.cybeleminigames.R

class SelectAdapter(private val items: ArrayList<SelectItemClass>, private val listener: ItemClicked): RecyclerView.Adapter<SelectAdapter.ViewHolder>() {

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val textView = itemView.findViewById<TextView>(R.id.selectItemText)
        val imageView = itemView.findViewById<ImageView>(R.id.selectItemImage)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.game_select, parent, false)
        val vh = ViewHolder(view)

        view.setOnClickListener {
            listener.onItemClicked(items[vh.absoluteAdapterPosition])
        }

        return vh
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.textView.text = items[position].text
        holder.imageView.setImageResource(items[position].imageURL)

    }

    override fun getItemCount(): Int {
        return items.size
    }
}

interface ItemClicked {
    fun onItemClicked(item: SelectItemClass)
}

