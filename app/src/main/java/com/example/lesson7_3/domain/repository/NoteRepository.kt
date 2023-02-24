package com.example.lesson7_3.domain.repository

import com.example.lesson7_3.domain.model.Note
import com.example.lesson7_3.domain.utils.Resource
import kotlinx.coroutines.flow.Flow

interface NoteRepository {

    fun createNote(note: Note): Flow<Resource<Unit>>

    fun editNote(note: Note): Flow<Resource<Unit>>

    fun deleteNote(note: Note): Flow<Resource<Unit>>

    fun getNote(): Flow<Resource<List<Note>>>
}