package com.example.materialyou.view.notesRecyclerView

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.materialyou.databinding.NotesFragmentBinding

class NotesFragment : Fragment() {
    companion object {
        fun newInstance() = NotesFragment()
    }

    var data = arrayListOf(
        Data(TYPE_STANDART, "notvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvve1", "1"),
        Data(TYPE_STANDART, "note2", "null"),
        Data(TYPE_HEADER_PICTURE, "note4", "nulggggggggggggggggggggggggggggggggggggggggggggggges"),
        Data(
            TYPE_STANDART,
            "note3",
            "45ggggggggggggggggggggggggggggggggggggggggggggggggggggggggg67"
        )
    )
    private lateinit var notesAdapter: NotesAdapter
    private var _binding: NotesFragmentBinding? = null
    private val binding: NotesFragmentBinding
        get() {
            return _binding!!
        }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = NotesFragmentBinding.inflate(inflater, container, false)
        notesAdapter = NotesAdapter(data, callbackDeleteItem)
        binding.notesFragmentRecyclerView.adapter = notesAdapter
        return binding.notesContainer
    }

    private val callbackDeleteItem = object : DeleteItem {
        override fun delete(position: Int) {
            data.removeAt(position)
            notesAdapter.setListDataDelete(data, position)
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.addNoteFab.setOnClickListener {
            data.add(data.size,Data(TYPE_STANDART, "New Note Header", "New note description"))
            notesAdapter.setListDataAdd(data)
        }
    }
}