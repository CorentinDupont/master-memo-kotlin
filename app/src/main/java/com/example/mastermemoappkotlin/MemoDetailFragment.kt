package com.example.mastermemoappkotlin

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment

/**
 * A simple [Fragment] subclass.
 * Use the [MemoDetailFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class MemoDetailFragment : Fragment() {

    private var memoText: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            memoText = it.getString(MEMO_TEXT_PARAM)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.memo_detail_fragment, container, false)
        val memoTextTV = view.findViewById<TextView>(R.id.memo_detail_text_tv)
        memoTextTV.text = memoText

        // return view
        return view
    }

    companion object {

        const val MEMO_TEXT_PARAM = "memo_text_param"

        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @return A new instance of fragment MemoDetailFragment.
         */
        @JvmStatic
        fun newInstance(memoText: String) =
            MemoDetailFragment().apply {
                arguments = Bundle().apply {
                    putString(MEMO_TEXT_PARAM, memoText)
                }
            }
    }
}
