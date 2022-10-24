package com.example.materialyou.view.notesRecyclerView

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.materialyou.databinding.PictureHeaderNoteItemBinding
import com.example.materialyou.databinding.StandartNoteItemBinding

class NotesAdapter(
    private var listData: MutableList<Data>,
    val callbackDelete: IDeleteItem,
    val callbackItemTypeChange: INoteTypeChange,
    val callbackEditItem: IEditItem
) :
    RecyclerView.Adapter<NotesAdapter.ElasticViewHolder>(), ItemTouchHelperAdapter{

    fun setListDataAdd(newListData: MutableList<Data>) {
        listData = newListData
        notifyItemInserted(listData.size)
    }

    fun setListDataDelete(newListData: MutableList<Data>, position: Int) {
        listData = newListData
        notifyItemRemoved(position)
    }

    fun setListDataChangeType(newListData: MutableList<Data>, position: Int) {
        listData = newListData
        notifyItemChanged(position)
    }

    fun setListDataEdit(newListData: MutableList<Data>, position: Int) {
        listData = newListData
        notifyItemChanged(position)
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
                binding.standartNoteHeader.isEnabled = false
                binding.standartNoteBody.isEnabled = false
                StandardNoteViewHolder(binding)

            }
            TYPE_HEADER_PICTURE -> {
                val binding =
                    PictureHeaderNoteItemBinding.inflate(
                        LayoutInflater.from(parent.context),
                        parent,
                        false
                    )
                binding.pictureHeaderNoteHeader.isEnabled = false
                PictureHeaderNoteViewHolder(binding)
            }
            else -> {
                val binding = StandartNoteItemBinding.inflate(
                    LayoutInflater.from(parent.context),
                    parent,
                    false
                )
                binding.standartNoteHeader.isEnabled = false
                binding.standartNoteBody.isEnabled = false
                StandardNoteViewHolder(binding)
            }
        }
    }

    override fun onBindViewHolder(holder: ElasticViewHolder, position: Int) =
        holder.bind(listData[position])


    override fun getItemCount(): Int {
        return listData.size
    }

    inner class StandardNoteViewHolder(val binding: StandartNoteItemBinding) :
        ElasticViewHolder(binding.root) {
        override fun bind(data: Data) {
            binding.apply {
                standartNoteHeader.setText(data.headerText)
                standartNoteBody.setText(data.descriptionText)

                editNoteIv.setOnClickListener {
                    data.editNote = !data.editNote
                    if (data.editNote) {
                        standartNoteHeader.isEnabled = true
                        standartNoteBody.isEnabled = true
                        data.headerText = standartNoteHeader.text.toString()
                        data.descriptionText = standartNoteBody.text.toString()
                    } else {
                        standartNoteHeader.isEnabled = false
                        standartNoteBody.isEnabled = false
                    }
                    callbackEditItem.edit(layoutPosition)
                }

                deleteIv.setOnClickListener {
                    callbackDelete.delete(layoutPosition)
                }

                changeNoteTypeIv.setOnClickListener {
                    data.type = (data.type + 1) % NUMBER_OF_TYPES
                    callbackItemTypeChange.changeType(layoutPosition)
                }
            }
        }
    }

    inner class PictureHeaderNoteViewHolder(val binding: PictureHeaderNoteItemBinding) :
        ElasticViewHolder(binding.root) {
        override fun bind(data: Data) {
            binding.apply {
                pictureHeaderNoteHeader.setText(data.headerText)
                pictureHeaderNotePicture.setImageResource(data.drawableRes)
                editNoteIv.setOnClickListener {
                    data.editNote = !data.editNote
                    if (data.editNote) {
                        pictureHeaderNoteHeader.isEnabled = true
                        data.headerText = pictureHeaderNoteHeader.text.toString()
                    } else {
                        pictureHeaderNotePicture.isEnabled = false
                    }
                    callbackEditItem.edit(layoutPosition)
                }

                deleteIv.setOnClickListener {
                    callbackDelete.delete(layoutPosition)
                }

                changeNoteTypeIv.setOnClickListener {
                    data.type = (data.type + 1) % NUMBER_OF_TYPES
                    callbackItemTypeChange.changeType(layoutPosition)
                }
            }
        }
    }

    abstract class ElasticViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        abstract fun bind(data: Data)
    }

    override fun onItemMove(fromPosition: Int, toPosition: Int) {
        listData.removeAt(fromPosition).apply {
            listData.add(toPosition, this)
        }
        notifyItemMoved(fromPosition, toPosition)
    }

    override fun onItemDelete(position: Int) {
        listData.removeAt(position)
        notifyItemRemoved(position)
    }
}