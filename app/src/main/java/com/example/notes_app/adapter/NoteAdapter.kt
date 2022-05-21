package com.example.notes_app.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.notes_app.R
import com.example.notes_app.entities.Notes
import kotlinx.android.synthetic.main.item_rv_notes.view.*

class NoteAdapter(val arrList: List<Notes>):
    RecyclerView.Adapter<NoteAdapter.NotesViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NotesViewHolder {
        return NotesViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.item_rv_notes,parent, false)
        )
    }

    override fun onBindViewHolder(holder: NotesViewHolder, position: Int) {

        holder.itemView.tvTitle.text = arrList[position].title
        holder.itemView.tvDesc.text = arrList[position].noteText
        holder.itemView.tvDateTime.text = arrList[position].dateTime
    }

    override fun getItemCount(): Int {
        return arrList.size
    }

    class NotesViewHolder(view: View): RecyclerView.ViewHolder(view){

    }

}