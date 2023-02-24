package com.example.lesson7_3.data.repository

import com.example.lesson7_3.data.base.BaseRepository
import com.example.lesson7_3.data.local.NoteDao
import com.example.lesson7_3.data.mappers.toNote
import com.example.lesson7_3.data.mappers.toNoteEntity
import com.example.lesson7_3.domain.model.Note
import com.example.lesson7_3.domain.repository.NoteRepository
import com.example.lesson7_3.domain.utils.Resource
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class NoteRepositoryImpl @Inject constructor(
    private val noteDao: NoteDao
) : BaseRepository(), NoteRepository {

    override fun createNote(note: Note): Flow<Resource<Unit>> = doRequest {
        noteDao.createNote(note.toNoteEntity())
    }

    override fun editNote(note: Note) : Flow<Resource<Unit>> = doRequest {
        noteDao.editNote(note.toNoteEntity())
    }

    override fun deleteNote(note: Note) = doRequest {
        noteDao.deleteNote(note.toNoteEntity())
    }

    override fun getNote() = doRequest {
        noteDao.getNote().map { it.toNote() }
    }


}