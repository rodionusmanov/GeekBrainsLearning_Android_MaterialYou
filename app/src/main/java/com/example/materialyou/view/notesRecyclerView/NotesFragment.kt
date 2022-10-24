package com.example.materialyou.view.notesRecyclerView

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.ItemTouchHelper
import com.example.materialyou.R
import com.example.materialyou.databinding.NotesFragmentBinding

class NotesFragment : Fragment() {
    companion object {
        fun newInstance() = NotesFragment()
    }

    var data = arrayListOf(
        Data(TYPE_STANDART, "NOTE 1", "description 1", R.drawable.sun, false),
        Data(TYPE_STANDART, "NOTE 2", "description 2", R.drawable.mercury, false),
        Data(
            TYPE_HEADER_PICTURE, "NOTE 3", "description 3", R.drawable.earth, false
        ),
        Data(
            TYPE_STANDART, "NOTE 4", "description 4", R.drawable.mars, false
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
        }
    }
}