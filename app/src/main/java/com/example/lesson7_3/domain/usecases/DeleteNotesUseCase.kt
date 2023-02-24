package com.example.lesson7_3.domain.usecases

import com.example.lesson7_3.domain.model.Note
import com.example.lesson7_3.domain.repository.NoteRepository
import javax.inject.Inject

class DeleteNotesUseCase @Inject constructor(private val noteRepository: NoteRepository) {
    
    fun deleteNotes(note: Note) = noteRepository.deleteNote(note)
}