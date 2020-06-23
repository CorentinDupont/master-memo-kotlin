package com.example.mastermemoappkotlin.repositories

import android.content.Context
import androidx.lifecycle.MutableLiveData
import com.example.mastermemoappkotlin.Models.AppDatabaseHelper
import com.example.mastermemoappkotlin.Models.DTO.MemosDTO

class MainRepository {

    fun getLiveDataMemos(context: Context, liveDataMemos: MutableLiveData<List<MemosDTO>>)
    {
        // get memos from database
        val listMemo = AppDatabaseHelper.getDatabase(context).memosDAO().getMemosList()
        liveDataMemos.value = (listMemo);
    }
}
