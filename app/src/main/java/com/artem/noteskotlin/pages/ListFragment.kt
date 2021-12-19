package com.artem.noteskotlin.pages

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.setFragmentResultListener
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.artem.noteskotlin.R
import com.artem.noteskotlin.adapters.NoteAdapter
import com.artem.noteskotlin.data.DataBase
import com.artem.noteskotlin.data.Note
import com.artem.noteskotlin.databinding.FragmentListBinding


class ListFragment : Fragment() {


    private lateinit var binding: FragmentListBinding
    private val adapter by lazy { NoteAdapter() }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentListBinding.inflate(inflater, container, false)
        return binding.root


    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initRecycleView()
        initButtons()

    }

    private fun initButtons() {
        binding.buttonAdd.setOnClickListener {
            parentFragmentManager.beginTransaction().replace(R.id.list_container, AddNoteFragment())
                .addToBackStack(null).commit()
        }
    }

    private fun initRecycleView() {
        with(binding) {
            recView.layoutManager = LinearLayoutManager(context)
            adapter.setData(DataBase.notes)
            recView.adapter = adapter
        }


    }
}