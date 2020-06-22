package com.example.mastermemoappkotlin.Models.DAO

import androidx.room.*
import com.example.mastermemoappkotlin.Models.DTO.MemosDTO


@Dao
public abstract class MemosDAO
{
    @Query("SELECT * FROM memos")
    abstract fun getMemosList(): List<MemosDTO>

    @Insert
    abstract fun insert(vararg memos: MemosDTO);

    @Update
    abstract fun update(vararg memos: MemosDTO);

    @Delete
    abstract fun delete(vararg memos: MemosDTO);
}