package com.example.materialyou.view.notesRecyclerView

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.ItemTouchHelper
import com.example.materialyou.R
import com.example.materialyou.databinding.NotesFragmentBinding
import com.example.materialyou.utils.setDefaultNotesData

class NotesFragment : Fragment() {

    var data = setDefaultNotesData()

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
        notesAdapter = NotesAdapter(data, callbackDeleteItem, callbackTypeChange, callbackEditItem)
        binding.notesFragmentRecyclerView.adapter = notesAdapter
        ItemTouchHelper(ItemTouchHelperCallback(notesAdapter)).attachToRecyclerView(binding.notesFragmentRecyclerView)
        return binding.notesContainer
    }

    private val callbackDeleteItem = object : IDeleteItem {
        override fun delete(position: Int) {
            data.removeAt(position)
            notesAdapter.setListDataDelete(data, position)
        }
    }

    private val callbackTypeChange = object : INoteTypeChange {
        override fun changeType(position: Int) {
            notesAdapter.setListDataChangeType(data, position)
            binding.notesFragmentRecyclerView.scrollToPosition(position)
        }
    }

    private val callbackEditItem = object : IEditItem {
        override fun edit(position: Int) {
            notesAdapter.setListDataEdit(data, position)
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.addNoteFab.setOnClickListener {
            data.add(
                data.size,
                Data(
                    TYPE_STANDART,
                    "New Note Header",
                    "New note description",
                    R.drawable.notes_icon,
                    false
                )
            )
            notesAdapter.setListDataAdd(data)
            binding.notesFragmentRecyclerView.scrollToPosition(data.size - 1)
        }
    }
}