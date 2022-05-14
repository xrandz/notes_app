package com.example.notes_app.entities

import androidx.room.ColumnInfo
import androidx.room.PrimaryKey
import androidx.room.Entity
import java.io.Serializable


@Entity(tableName = "Notes")
data class Notes(

    @PrimaryKey(autoGenerate = true)
    var id:Int,

    @ColumnInfo(name = "title")
    var title:String,

    @ColumnInfo(name = "sub_tttle")
    var subTitle: String,

    @ColumnInfo(name = "date_time")
    var dateTime: String,

    @ColumnInfo(name = "note_text")
    var noteText:String,

    @ColumnInfo(name = "img_path")
    var imgPath:String,

    @ColumnInfo(name = "web_link")
    var webLink:String,

    @ColumnInfo(name = "color")
    var color:String

): Serializable {
    override fun toString(): String {
        return "$title: $dateTime"
    }
}