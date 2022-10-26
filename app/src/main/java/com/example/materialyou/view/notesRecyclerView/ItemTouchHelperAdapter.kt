package com.example.materialyou.view.notesRecyclerView

interface ItemTouchHelperAdapter {
    fun onItemMove(fromPosition: Int, toPosition: Int)
    fun onItemDelete(position: Int)
}

interface ItemTouchHelperViewHolder{
    fun onItemSelect()
    fun onItemClear()
}