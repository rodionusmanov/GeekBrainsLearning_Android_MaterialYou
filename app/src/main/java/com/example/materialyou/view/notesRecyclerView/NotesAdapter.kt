package com.example.materialyou.view.notesRecyclerView

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.materialyou.R
import com.example.materialyou.databinding.PictureHeaderNoteItemBinding
import com.example.materialyou.databinding.StandartNoteItemBinding

class NotesAdapter(val listData: List<Data>) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    override fun getItemViewType(position: Int): Int {
        return listData[position].type
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {

        return when (viewType) {
            TYPE_STANDART -> {
                val binding = StandartNoteItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
                StandartNoteViewHolder(binding)
            }
            TYPE_HEADER_PICTURE -> {
                val binding =
                    PictureHeaderNoteItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
                PictureHeaderNoteViewHolder(binding)
            }
            else -> {
                val binding = StandartNoteItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
                StandartNoteViewHolder(binding)
            }
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) =
        when (getItemViewType(position)) {
        TYPE_STANDART -> {
            (holder as StandartNoteViewHolder).bind(listData[position])
        }
        /*TYPE_STANDART -> {
            (holder as PictureHeaderNoteViewHolder).bind(listData[position])
        }*/
        else -> (holder as PictureHeaderNoteViewHolder).bind(listData[position])
    }
//        holder.bind(listData[position])

    override fun getItemCount(): Int {
        return listData.size
    }

    class StandartNoteViewHolder(val binding: StandartNoteItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(data: Data) {
            binding.apply {
                standartNoteHeader.text = data.headerText
                standartNoteBody.text = data.descriptionText
            }
        }
    }

    class PictureHeaderNoteViewHolder(val binding: PictureHeaderNoteItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(data: Data) {
            binding.apply {
                pictureHeaderNoteHeader.text = data.headerText
                pictureHeaderNotePicture.setImageResource(R.drawable.saturn)
            }
        }
    }

}