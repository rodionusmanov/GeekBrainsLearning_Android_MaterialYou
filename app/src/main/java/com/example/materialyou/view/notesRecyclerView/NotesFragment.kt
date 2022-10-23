package com.example.materialyou.view.notesRecyclerView

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.materialyou.R
import com.example.materialyou.databinding.NotesFragmentBinding

class NotesFragment : Fragment() {
    companion object {
        fun newInstance() = NotesFragment()
    }

    val data = arrayListOf(
        Data(TYPE_STANDART, "note1", "1"),
        Data(TYPE_STANDART, "note2", "null"),
        Data(TYPE_HEADER_PICTURE, "note4", "nulggggggggggggggggggggggggggggggggggggggggggggggges"),
        Data(
            TYPE_STANDART,
            "note3",
            "45ggggggggggggggggggggggggggggggggggggggggggggggggggggggggg67"
        )
    )
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
        binding.notesFragmentRecyclerView.adapter = NotesAdapter(data)
        return binding.notesContainer
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}