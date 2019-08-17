package com.muhammadabdullah.bubblebookshelf.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
class BookPagesModel (
    @PrimaryKey var pageId : Int,
    @ColumnInfo var pageName : String,
    @ColumnInfo var pageImageUrl : String,
    @ColumnInfo var pageAudioFileUrl : String,
    @ColumnInfo var bookId : Int
)