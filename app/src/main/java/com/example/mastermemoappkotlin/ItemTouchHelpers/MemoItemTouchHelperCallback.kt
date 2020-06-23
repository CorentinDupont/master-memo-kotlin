package com.example.mastermemoappkotlin.ItemTouchHelpers

import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.RecyclerView
import com.example.mastermemoappkotlin.adapters.MemoAdapter

class MemoItemTouchHelperCallback(adapter: MemoAdapter) : ItemTouchHelper.Callback() {

    private val adapter: MemoAdapter = adapter

    override fun isLongPressDragEnabled(): Boolean {
        return true
    }

    override fun isItemViewSwipeEnabled(): Boolean {
        return true
    }

    override fun getMovementFlags(
        recyclerView: RecyclerView,
        viewHolder: RecyclerView.ViewHolder
    ): Int {
        val dragFlagsUpDown = ItemTouchHelper.UP or ItemTouchHelper.DOWN
        val dragFlagsLeftRight = ItemTouchHelper.RIGHT
        return makeMovementFlags(
            dragFlagsUpDown,
            dragFlagsLeftRight
        )
    }

    override fun onMove(
        recyclerView: RecyclerView, viewHolder: RecyclerView.ViewHolder,
        target: RecyclerView.ViewHolder
    ): Boolean {
        adapter.onItemMove(viewHolder.adapterPosition, target.adapterPosition)
        return true
    }

    override fun onSwiped(viewHolder: RecyclerView.ViewHolder, direction: Int) {
        adapter.onItemDismiss(viewHolder.adapterPosition)
    }

}