package com.artem.noteskotlin.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.viewbinding.ViewBinding
import com.artem.noteskotlin.Note
import com.artem.noteskotlin.R
import com.artem.noteskotlin.data.DataBase
import com.artem.noteskotlin.databinding.ItemNoteBinding

class NoteAdapter(private val dataSet: DataBase) :
    RecyclerView.Adapter<NoteAdapter.ViewHolder>() {


    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(ItemNoteBinding.inflate(LayoutInflater.from(viewGroup.context)))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val note = dataSet.notes[position]
        with(holder.binding) {
            noteName.text = note.name
            noteDate.text = note.date
            noteCheckbox.isChecked = note.done_state


        }
    }

    override fun getItemCount(): Int {
        return dataSet.notes.size
    }


    class ViewHolder(val binding: ItemNoteBinding) : RecyclerView.ViewHolder(binding.root) {


    }


}