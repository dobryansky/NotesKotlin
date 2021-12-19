package com.artem.noteskotlin.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.artem.noteskotlin.data.DataBase
import com.artem.noteskotlin.data.Note
import com.artem.noteskotlin.data.NotesDiffUtil
import com.artem.noteskotlin.databinding.ItemNoteBinding

class NoteAdapter :
    RecyclerView.Adapter<NoteAdapter.ViewHolder>() {
private var noteList= DataBase.notes

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(ItemNoteBinding.inflate(LayoutInflater.from(viewGroup.context)))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val note = noteList[position]
        with(holder.binding) {
            noteName.text = note.name
            noteDate.text = note.date
            idNote.text = "id - #"+ note.id.toString()
            noteCheckbox.isChecked = note.done_state

        }
    }

    override fun getItemCount(): Int {
        return noteList.size
    }

    fun setData(newList: List<Note>) {
        val difUtil = NotesDiffUtil(noteList, newList)
        val diffResults = DiffUtil.calculateDiff(difUtil)
        noteList=newList
        diffResults.dispatchUpdatesTo(this)

    }


    class ViewHolder(val binding: ItemNoteBinding) : RecyclerView.ViewHolder(binding.root) {


    }


}