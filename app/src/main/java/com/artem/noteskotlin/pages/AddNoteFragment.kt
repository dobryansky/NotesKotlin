package com.artem.noteskotlin.pages

import android.app.DatePickerDialog
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.setFragmentResult
import com.artem.noteskotlin.R
import com.artem.noteskotlin.data.DataBase
import com.artem.noteskotlin.data.Note
import com.artem.noteskotlin.databinding.FragmentAddNoteBinding
import com.artem.noteskotlin.databinding.FragmentListBinding
import java.util.*
import kotlin.random.Random


class AddNoteFragment : Fragment() {

    private lateinit var binding: FragmentAddNoteBinding


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentAddNoteBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initViews()
    }

    private fun initViews() {

        with(binding) {
            btnBack.setOnClickListener {
                parentFragmentManager.popBackStack()
            }
            btnAddNote.setOnClickListener {
                val newName = addNoteName.text.toString()
                val newDescription = addNoteDescription.text.toString()
                val newDate = textAddDate.text.toString()
                DataBase.addNote(
                    Note(
                        Random.nextInt(10000),
                        newName,
                        newDescription,
                        newDate,
                        false
                    )
                )
                parentFragmentManager.popBackStack()


            }
            editDateDatePicker.setOnClickListener {
                val c = Calendar.getInstance()
                val year = c.get(Calendar.YEAR)
                val month = c.get(Calendar.MONTH)
                val day = c.get(Calendar.DAY_OF_MONTH)
                val dpd = DatePickerDialog(
                    requireContext(),
                    DatePickerDialog.OnDateSetListener { view, year, month, day ->
                        textAddDate.setText("$day.$month.$year")
                    },
                    year,
                    month,
                    day
                )
                dpd.show()
            }


        }

    }
}