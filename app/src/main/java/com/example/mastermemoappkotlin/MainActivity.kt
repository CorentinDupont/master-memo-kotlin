package com.example.mastermemoappkotlin

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.mastermemoappkotlin.Models.AppDatabaseHelper
import com.example.mastermemoappkotlin.Models.DTO.MemosDTO
import com.example.mastermemoappkotlin.adapters.MemoAdapter

class MainActivity : AppCompatActivity(), View.OnClickListener, MemoAdapter.OnMemoListener  {

    // memo list
    lateinit var listMemo: MutableList<MemosDTO>

    // memo list adapter
    lateinit var memoAdapter: MemoAdapter

    // memo recycler view
    lateinit var recyclerView: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // get recycler view
        recyclerView = findViewById(R.id.memo_rv)
        recyclerView.setHasFixedSize(true)

        // item disposition
        val layoutManager = LinearLayoutManager(this)
        layoutManager.reverseLayout = true
        layoutManager.stackFromEnd = true
        recyclerView.layoutManager = layoutManager

        // get memos from database
        listMemo = AppDatabaseHelper.getDatabase(this).memosDAO().getMemosList().toMutableList()

        // create and set recycler view adapter
        memoAdapter = MemoAdapter(listMemo, this)
        recyclerView.adapter = memoAdapter

        // handle adding memos
        val addMemoButton = findViewById<Button>(R.id.memo_ok_button)
        addMemoButton.setOnClickListener(this)
    }

    override fun onClick(v: View) {

        // handle OK button click to insert a new memo in the recycler view
        if (v.id == R.id.memo_ok_button) {

            // create memo and insert it in the database
            val memoET = findViewById<EditText>(R.id.memo_text_et)
            val memo = MemosDTO(memoET.text.toString())
            AppDatabaseHelper.getDatabase(this).memosDAO().insert(memo)

            // refresh list
            listMemo.clear()
            val newMemoList: List<MemosDTO> =
                AppDatabaseHelper.getDatabase(this).memosDAO().getMemosList()
            listMemo.addAll(newMemoList)
            //memoAdapter.notifyDataSetChanged()
            memoAdapter.notifyItemInserted(listMemo.size - 1)
            recyclerView.smoothScrollToPosition(listMemo.size - 1)
        }
    }

    override fun onMemoClick(position: Int, memo: MemosDTO) {
        showMemoDetails(memo)
    }

    /**
     * Open the memo details fragment, as a new activity if portrait, or make appearing
     * fragment in current activity.
     * @param memo memo to display the details from.
     */
    private fun showMemoDetails(memo: MemosDTO) {
        Log.i("MainActivity", memo.text)
        /*if (resources.configuration.orientation == Configuration.ORIENTATION_LANDSCAPE) {
            // create fragment
            val fragment = MemoDetailFragment()
            val bundle = Bundle()
            bundle.putString(MemoDetailFragment.MEMO_TEXT_PARAM, memo.getText())
            fragment.setArguments(bundle)

            // display fragment
            supportFragmentManager.beginTransaction()
                .replace(R.id.main_memo_detail_frame_layout, fragment).commit()
        } else {
            val intent = Intent(this, MemoDetailActivity::class.java)
            intent.putExtra(MemoDetailFragment.MEMO_TEXT_PARAM, memo.getText())
            startActivity(intent)
        }*/
    }
}
