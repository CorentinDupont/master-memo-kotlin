package com.example.mastermemoappkotlin

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

class MemoDetailActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_memo_detail)

        // create fragment
        val fragment = MemoDetailFragment()
        val bundle = Bundle()
        bundle.putString(
            MemoDetailFragment.MEMO_TEXT_PARAM,
            intent.getStringExtra(MemoDetailFragment.MEMO_TEXT_PARAM)
        )
        fragment.arguments = bundle

        // display fragment
        supportFragmentManager.beginTransaction()
            .replace(R.id.detail_memo_frame_layout, fragment).commit()
    }
}
