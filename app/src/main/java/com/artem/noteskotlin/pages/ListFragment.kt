package com.artem.noteskotlin.pages

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.artem.noteskotlin.adapters.NoteAdapter
import com.artem.noteskotlin.data.DataBase
import com.artem.noteskotlin.data.Note
import com.artem.noteskotlin.databinding.FragmentListBinding




class ListFragment : Fragment() {


    private lateinit var binding: FragmentListBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding= FragmentListBinding.inflate(inflater, container, false)
        return binding.root



    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initRecycleView()
    }

    private fun initRecycleView() {
        /*DataBase.addNote(Note("ewfwef","wefewfewf",false))
        DataBase.addNote(Note("ewfwef","wefewfewf",false))
        DataBase.addNote(Note("ewfwef","wefe243423wfewf",true))*/
        val adapter= NoteAdapter(DataBase)
        binding.recView.layoutManager=LinearLayoutManager(context)
        binding.recView.adapter=adapter

    }
}