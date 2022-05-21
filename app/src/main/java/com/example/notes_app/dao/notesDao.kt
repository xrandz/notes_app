package com.example.notes_app.dao

import androidx.room.*
import com.example.notes_app.entities.Notes

@Dao
interface notesDao {

    @Query("SELECT* FROM notes ORDER BY id DESC")
    suspend fun getAllNotes():List<Notes>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertNotes(notes: Notes)

    @Delete
    suspend fun deleteNote(notes: Notes)
}

