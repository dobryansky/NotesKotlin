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
import com.artem.noteskotlin.adapters.FakeNoteAdapter
import com.artem.noteskotlin.adapters.NoteAdapter
import com.artem.noteskotlin.data.DataBase
import com.artem.noteskotlin.data.Note
import com.artem.noteskotlin.databinding.FragmentListBinding
import com.artem.noteskotlin.model.App
import com.artem.noteskotlin.model.FakeNoteListener
import com.artem.noteskotlin.model.FakeNoteService


class ListFragment : Fragment() {


    private lateinit var binding: FragmentListBinding
    private lateinit var adapter: FakeNoteAdapter
    private  val fakeNoteService: FakeNoteService
    get() = (activity?.applicationContext as App).fakeList


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
        fakeNoteService.addListener(fakeNoteListener)

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
            adapter = FakeNoteAdapter()
            recView.adapter = adapter
        }


    }

    private val fakeNoteListener: FakeNoteListener = {
        adapter.fakeList = it
    }

}