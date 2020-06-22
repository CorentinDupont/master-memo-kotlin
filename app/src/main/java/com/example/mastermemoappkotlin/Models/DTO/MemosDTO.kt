package com.example.mastermemoappkotlin.Models.DTO

import androidx.room.Entity
import androidx.room.PrimaryKey




@Entity(tableName = "memos")
class MemosDTO {

    @PrimaryKey(autoGenerate = true)
    var memoId: Long = 0

    var text: String = ""

    constructor(text: String) {
        this.text = text;
    }

}