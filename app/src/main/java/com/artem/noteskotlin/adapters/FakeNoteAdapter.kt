package com.artem.noteskotlin.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.artem.noteskotlin.R
import com.artem.noteskotlin.data.DataBase
import com.artem.noteskotlin.data.Note
import com.artem.noteskotlin.data.NotesDiffUtil
import com.artem.noteskotlin.databinding.ItemNoteBinding
import com.artem.noteskotlin.model.FakeNote
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import com.bumptech.glide.request.RequestOptions
import java.security.AccessController.getContext

class FakeNoteAdapter :
    RecyclerView.Adapter<FakeNoteAdapter.ViewHolder>() {
     var fakeList: List<FakeNote> = emptyList()
        set(newValue) {
            field = newValue
            notifyDataSetChanged()
        }

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(ItemNoteBinding.inflate(LayoutInflater.from(viewGroup.context)))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val note = fakeList[position]
        with(holder.binding) {
            idNote.text = note.id.toString()
            noteName.text = note.name
            noteDate.text = note.date
            idNote.text = "id - #" + note.id.toString()
            if (note.image.isNotBlank()) {
                Glide.with(imageViewItem)
                    .load(note.image)
                    .diskCacheStrategy(DiskCacheStrategy.NONE)
                    .apply(RequestOptions.bitmapTransform(RoundedCorners(20)))
                    .skipMemoryCache(true)
                    .into(imageViewItem)
            } else {
                imageViewItem.setImageResource(R.drawable.ic_note)
            }
            noteCheckbox.isChecked = note.done_state
        }
    }

    override fun getItemCount(): Int {
        return fakeList.size
    }

    /*  fun setData(newList: List<Note>) {
          val difUtil = NotesDiffUtil(fakeList, newList)
          val diffResults = DiffUtil.calculateDiff(difUtil)
          fakeList = newList
          diffResults.dispatchUpdatesTo(this)
      }
  */

    class ViewHolder(val binding: ItemNoteBinding) : RecyclerView.ViewHolder(binding.root) {

    }


}