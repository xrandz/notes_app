package com.example.notes_app.dao

import androidx.room.*
import com.example.notes_app.entities.Notes

@Dao
interface notesDao {

    @get:Query("SELECT* FROM notes ORDER by id DESC")
    val allNotes:List<Notes>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertNotes(notes: Notes)

    @Delete
    fun deleteNote(notes: Notes)
}

