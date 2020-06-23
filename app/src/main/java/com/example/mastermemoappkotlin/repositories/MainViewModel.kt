package com.example.mastermemoappkotlin.repositories

import android.content.ClipData.Item
import android.content.Context
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.mastermemoappkotlin.Models.DTO.MemosDTO


class MainViewModel: ViewModel() {

    // Repository
    private var mainRepository: MainRepository? = null

    // LiveData item
    var liveDataMemos: MutableLiveData<List<MemosDTO>>? = null

    // Init
    fun init(mainRepository: MainRepository?) {

        if (liveDataMemos != null) {
            return
        }

        // first loading
        this.mainRepository = mainRepository
        liveDataMemos = MutableLiveData()
    }

    // get memos list
    fun loadMemosList(context: Context) {
        mainRepository?.getLiveDataMemos(context, liveDataMemos!!)
    }

}