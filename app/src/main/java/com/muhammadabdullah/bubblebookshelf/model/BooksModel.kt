package com.muhammadabdullah.bubblebookshelf.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.amazonaws.mobileconnectors.dynamodbv2.dynamodbmapper.*

@DynamoDBTable(tableName = "bubblebookshelf-mobilehub-851917518-books")
@Entity
class BooksModel (
    @DynamoDBHashKey(attributeName = "book_id")
    @DynamoDBIndexRangeKey(attributeName = "book_id", globalSecondaryIndexName = "book_category_idx")
    @PrimaryKey var bookId : Int,

    @DynamoDBAttribute(attributeName = "book_name")
    @ColumnInfo var bookName : String,

    @DynamoDBIndexHashKey(attributeName = "book_category", globalSecondaryIndexName = "book_category_idx")
    @ColumnInfo var bookCategory : String,

    @DynamoDBAttribute(attributeName = "book_image_url")
    @ColumnInfo var bookImageUrl : String
){
    constructor():this(-1, "","","")

    override fun toString(): String {
        return "BooksModel(bookId=$bookId, bookName='$bookName', bookCategory='$bookCategory', bookImageUrl='$bookImageUrl')"
    }


}
