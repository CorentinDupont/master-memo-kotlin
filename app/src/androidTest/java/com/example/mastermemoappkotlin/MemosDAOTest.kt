package com.example.mastermemoappkotlin

import android.content.Context
import androidx.test.core.app.ApplicationProvider
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.example.mastermemoappkotlin.Models.AppDatabaseHelper
import com.example.mastermemoappkotlin.Models.DTO.MemosDTO
import org.junit.Assert
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class MemosDAOTest {
    @Test
    fun insertOneMemo() {
        val context: Context = ApplicationProvider.getApplicationContext()

        val memosDAO = AppDatabaseHelper.getDatabase(context).memosDAO()
        val previousMemosListSize = memosDAO.getMemosList().size;

        val newMemo = MemosDTO("A memo from a test")
        memosDAO.insert(newMemo)

        val memos: List<MemosDTO> = memosDAO.getMemosList()

        Assert.assertEquals(previousMemosListSize + 1, memos.size)
    }

}