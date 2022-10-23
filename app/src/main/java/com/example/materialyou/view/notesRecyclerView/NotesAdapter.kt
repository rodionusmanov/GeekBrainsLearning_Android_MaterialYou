package com.example.materialyou.view.notesRecyclerView

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.materialyou.R
import com.example.materialyou.databinding.PictureHeaderNoteItemBinding
import com.example.materialyou.databinding.StandartNoteItemBinding

class NotesAdapter(var listData: List<Data>, val callbackDelete: DeleteItem) :
    RecyclerView.Adapter<NotesAdapter.ElasticViewHolder>() {

    fun setListDataAdd(newListData: List<Data>){
        listData = newListData
        notifyDataSetChanged()
    }

    fun setListDataDelete(newListData: List<Data>, position: Int){
        listData = newListData
        notifyDataSetChanged()
    }

    override fun getItemViewType(position: Int): Int {
        return listData[position].type
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ElasticViewHolder {
        return when (viewType) {
            TYPE_STANDART -> {
                val binding = StandartNoteItemBinding.inflate(
                    LayoutInflater.from(parent.context),
                    parent,
                    false
                )
                StandartNoteViewHolder(binding)
            }
            TYPE_HEADER_PICTURE -> {
                val binding =
                    PictureHeaderNoteItemBinding.inflate(
                        LayoutInflater.from(parent.context),
                        parent,
                        false
                    )
                PictureHeaderNoteViewHolder(binding)
            }
            else -> {
                val binding = StandartNoteItemBinding.inflate(
                    LayoutInflater.from(parent.context),
                    parent,
                    false
                )
                StandartNoteViewHolder(binding)
            }
        }
    }

    override fun onBindViewHolder(holder: ElasticViewHolder, position: Int) =
        holder.bind(listData[position])


    override fun getItemCount(): Int {
        return listData.size
    }

    inner class StandartNoteViewHolder(val binding: StandartNoteItemBinding) :
        ElasticViewHolder(binding.root) {
        override fun bind(data: Data) {
            binding.apply {
                standartNoteHeader.text = data.headerText
                standartNoteBody.text = data.descriptionText
            }
            binding.deleteIv.setOnClickListener {
                callbackDelete.delete(layoutPosition)
            }
        }
    }

    class PictureHeaderNoteViewHolder(val binding: PictureHeaderNoteItemBinding) :
        ElasticViewHolder(binding.root) {
        override fun bind(data: Data) {
            binding.apply {
                pictureHeaderNoteHeader.text = data.headerText
                pictureHeaderNotePicture.setImageResource(R.drawable.saturn)
            }
//            binding.add
        }
    }

    abstract class ElasticViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        abstract fun bind(data: Data)
    }
}