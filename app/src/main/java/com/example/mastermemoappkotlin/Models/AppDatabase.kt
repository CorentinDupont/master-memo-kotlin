package com.example.mastermemoappkotlin.Models

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.mastermemoappkotlin.Models.DAO.MemosDAO
import com.example.mastermemoappkotlin.Models.DTO.MemosDTO

@Database(entities = [MemosDTO::class], version = 1)
abstract class AppDatabase: RoomDatabase() {
    abstract fun memosDAO(): MemosDAO
}
