package com.example.mastermemoappkotlin.adapters

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.mastermemoappkotlin.Models.DTO.MemosDTO
import com.example.mastermemoappkotlin.R
import kotlinx.android.synthetic.main.item_memo.view.*
import java.util.*

class MemoAdapter(
    listMemo: MutableList<MemosDTO>,
    onMemoListener: OnMemoListener
) :
    RecyclerView.Adapter<MemoAdapter.MemoViewHolder>() {

    private val listMemo: MutableList<MemosDTO>
    private val onMemoListener: OnMemoListener

    init {
        this.listMemo = listMemo
        this.onMemoListener = onMemoListener
    }

    override fun onCreateViewHolder(
        viewGroup: ViewGroup,
        i: Int
    ): MemoViewHolder {

        val viewMemo: View = LayoutInflater.from(viewGroup.context)
            .inflate(R.layout.item_memo, viewGroup, false)

        return MemoViewHolder(
            viewMemo,
            onMemoListener
        )
    }

    override fun onBindViewHolder(
        memoViewHolder: MemoViewHolder,
        i: Int
    ) {
        memoViewHolder.getMemoTextTV().text = listMemo[i].text
    }

    override fun getItemCount(): Int {
        return listMemo.size
    }

    // Called on each position change, during an item move.
    fun onItemMove(startPosition: Int, endPosition: Int): Boolean {
        Collections.swap(listMemo, startPosition, endPosition)
        notifyItemMoved(startPosition, endPosition)
        return true
    }

    // Called one time on item deletion
    fun onItemDismiss(position: Int) {
        if (position > -1) {
            listMemo.removeAt(position)
            notifyItemRemoved(position)
        }
    }

    inner class MemoViewHolder(
        itemView: View,
        onMemoListener: OnMemoListener
    ) :
        RecyclerView.ViewHolder(itemView), View.OnClickListener {

        private var memoTextTV: TextView = itemView.memo_text_tv
        private var onMemoListener: OnMemoListener

        init {
            this.onMemoListener = onMemoListener
            // add on click listener to show content of the memo.
            itemView.setOnClickListener(this)
        }

        override fun onClick(v: View) {
            Log.i(
                "MemoViewHolder",
                "Clicked Memo"
            )
            val memo: MemosDTO = listMemo[adapterPosition]

            // Activity on click listener
            onMemoListener.onMemoClick(adapterPosition, memo)
        }

        fun getMemoTextTV(): TextView {
            return memoTextTV
        }


    }

    interface OnMemoListener {
        fun onMemoClick(position: Int, memo: MemosDTO)
    }

}